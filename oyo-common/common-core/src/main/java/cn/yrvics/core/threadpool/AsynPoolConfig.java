package cn.yrvics.core.threadpool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 需要使用@EnableAsync开启异步
 * 自定义异步线程池
 * @Author YRVICS
 */
@EnableAsync
@Configuration
public class AsynPoolConfig {

    /**
     * 需要异步的方法添加注解
     * @Async("oyoThreadPoolTaskExecutor")
     * @return
     */
    @Bean("oyoThreadPoolTaskExecutor")
    public ThreadPoolTaskExecutor oyoThreadPoolTaskExecutor(){
        //创建线程池
        ThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutor();
        //线程池核心线程数量
        executor.setCorePoolSize(8);
        //线程池维护线程最大数量，当核心线程数量和缓冲队列都占满了，就会再申请线程
        //线程池最大承载 max+queue
        executor.setMaxPoolSize(12);
        //缓冲队列
        executor.setQueueCapacity(30);
        //超出核心线程外的线程在空闲时候的最大存货时间，默认60秒
        executor.setKeepAliveSeconds(60);
        //线程名前缀
        executor.setThreadNamePrefix("oyoAsyncThread");
        //是否等待所有线程执行完成后才关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //等待的时长，默认为0即不等待
        executor.setAwaitTerminationSeconds(60);
        //设置拒绝策略
//        ThreadPoolExecutor.AbortPolicy()  抛出java.util.concurrent.RejectedExecutionException异常
//        ThreadPoolExecutor.CallerRunsPolicy() 重试添加当前的任务，他会自动重复调用execute()方法
//        ThreadPoolExecutor.DiscardOldestPolicy() 抛弃旧的任务
//        ThreadPoolExecutor.DiscardPolicy() 抛弃当前的任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }


    //第二种使用线程池的方式
//    public static void main(String[] args) {
//        ThreadPoolTaskExecutor poolTaskExecutor = SpringUtil.getBean("oyoThreadPoolTaskExecutor", ThreadPoolTaskExecutor.class);
//        Future<String> future = poolTaskExecutor.submit(() -> aaa());
//    }
//
//    public static String aaa(){
//        return "aaa";
//    }
}

/**
 * 第一种使用线程池的方式
 *  @Async("kebolThreadPoolTaskExecutor")
 *     public Future<String> asyncTest(){
 *         try {
 *             TimeUnit.SECONDS.sleep(5);
 *         } catch (InterruptedException e) {
 *             e.printStackTrace();
 *         }
 *         return new AsyncResult<>("test");
 *     }
 */
