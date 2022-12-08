package cn.yrvics.reids.config;

import cn.yrvics.reids.properties.RedissionProperties;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.StringUtils;

import java.time.Duration;

/**
 * Redis配置
 * @Author YRVICS
 */
@Configuration
@EnableConfigurationProperties({RedissionProperties.class, RedisProperties.class})
public class RedisConfig {

    /**
     * Redis配置信息
     */
    @Autowired
    private RedisProperties redisProperties;

    /**
     * Redission配置信息
     */
    @Autowired
    private RedissionProperties redissionProperties;

    /**
     * 使用jackson序列化redis数据
     * 如果使用fastjson，可以看下
     *
     * @param redisConnectionFactory
     * @return
     * @see com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer 貌似可以直接使用这个fastjson序列化器，而不用自己实现序列化器
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 配置连接工厂
        template.setConnectionFactory(redisConnectionFactory);

        //key序列化方式,value序列化
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(redisSerializer());
        // 设置hash key 和value序列化模式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(redisSerializer());
//        template.setHashValueSerializer(new GenericFastJsonRedisSerializer()); //使用fastjson序列化
        //必须执行这个函数,初始化RedisTemplate
        template.afterPropertiesSet();
        return template;
    }


    /**
     * JSON序列化器
     *
     * @return
     */
    @Bean
    public RedisSerializer<Object> redisSerializer() {
        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
        Jackson2JsonRedisSerializer<Object> jacksonSeial = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常；
        // 必须设置，否则无法将JSON转化为对象，会转化成Map类型
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
        jacksonSeial.setObjectMapper(om);
        return jacksonSeial;
    }


    /**
     * Spring-Cache 缓存管理器序列化配置
     *
     * @param factory
     * @return
     */
    //    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        // 配置序列化（解决乱码的问题）,过期时间600秒
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofDays(1)) //设置Redis缓存有效期为1天
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer())) //配置json序列化器，也可以使用new GenericFastJsonRedisSerializer()
                .disableCachingNullValues();
        RedisCacheManager cacheManager = RedisCacheManager.builder(factory)
                .cacheDefaults(config)
                .build();
        return cacheManager;
    }



    /**
     * 单机Redisson配置
     * @return
     */
    @Bean
//    @ConditionalOnProperty(name = "spring.redis.model", havingValue = "single")
    public RedissonClient getSingleRedisson() {
        Config config = new Config();
        //用"redis://"来启用SSL连接
        String node = "redis://" + redisProperties.getHost()+":"+redisProperties.getPort();
        SingleServerConfig serverConfig = config.useSingleServer();
        serverConfig.setAddress(node);
//                .setConnectionPoolSize(redissionProperties.getPool().getSize())
//                .setTimeout(redissionProperties.getPool().getTimeout())
//                .setConnectionMinimumIdleSize(redissionProperties.getPool().getMinIdle());
        if (StringUtils.hasLength(redisProperties.getPassword())) {
            serverConfig.setPassword(redisProperties.getPassword());
        }
        return Redisson.create(config);
    }

    /**
     * 集群Redisson
     * @return
     */
//    @Bean
//    @ConditionalOnProperty(name = "spring.redis.model", havingValue = "cluster")
//    public RedissonClient getClusterRedisson() {
//        Config config = new Config();
//
//        //用"rediss://"来启用SSL连接
//        List<String> newNodes = redisProperties.getCluster().getNodes()
//                .stream()
//                .map(node -> node.startsWith("redis://") ? node : "redis://" + node)
//                .collect(Collectors.toList());
//
//        ClusterServersConfig serverConfig = config.useClusterServers()
//                .addNodeAddress(newNodes.toArray(new String[0]))
//                .setScanInterval(
//                        redissionProperties.getCluster().getScanInterval())
//                .setIdleConnectionTimeout(
//                        redissionProperties.getPool().getSoTimeout())
//                .setConnectTimeout(
//                        redissionProperties.getPool().getConnTimeout())
//                .setRetryAttempts(
//                        redissionProperties.getCluster().getRetryAttempts())
//                .setRetryInterval(
//                        redissionProperties.getCluster().getRetryInterval())
//                .setMasterConnectionPoolSize(redissionProperties.getCluster()
//                        .getMasterConnectionPoolSize())
//                .setSlaveConnectionPoolSize(redissionProperties.getCluster()
//                        .getSlaveConnectionPoolSize())
//                .setTimeout(redissionProperties.getPool().getTimeout());
//        if (StringUtils.isNotBlank(redisProperties.getPassword())) {
//            serverConfig.setPassword(redisProperties.getPassword());
//        }
//        return Redisson.create(config);
//    }
}
