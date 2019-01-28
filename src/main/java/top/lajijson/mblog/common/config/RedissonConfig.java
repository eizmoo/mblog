package top.lajijson.mblog.common.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * redisson配置类
 *
 * @author liuwei
 */
@Configuration
public class RedissonConfig {
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    //    @Value("${spring.redis.password}")
    private String password;

    //    @Value("${spring.redis.pool.min-idle}")
    private int minIdle;

    //    @Value("${spring.redis.pool.max-active}")
    private int maxActive;

    //    @Value("${spring.redis.pool.max-wait}")
    private int timeout;

    @Bean
    public RedissonClient getRedisson() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + host + ":" + port)
//                .setPassword(password)
//                .setConnectionPoolSize(maxActive)
//                .setConnectionMinimumIdleSize(minIdle)
//                .setConnectTimeout(timeout)
        ;
        return Redisson.create(config);
    }
}
