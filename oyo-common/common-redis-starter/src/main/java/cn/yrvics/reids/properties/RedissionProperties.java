package cn.yrvics.reids.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.redis.redission")
public class RedissionProperties {


    private final Pool pool = new Pool();


    public static class Pool {


        private int size = 8;

        private int timeout = 0;

        private int minIdle = 0;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTimeout() {
            return timeout;
        }

        public void setTimeout(int timeout) {
            this.timeout = timeout;
        }

        public int getMinIdle() {
            return minIdle;
        }

        public void setMinIdle(int minIdle) {
            this.minIdle = minIdle;
        }
    }

    public Pool getPool() {
        return this.pool;
    }


}
