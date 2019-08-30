package com.ximalaya.webgroup.tdkservice.core.redis;


import com.ximalaya.webgroup.tdkservice.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "redis.main")
    public RedisConfig mainConfig() {
        return new RedisConfig();
    }

    @Bean
    public StringRedisTemplate mainRedisTemplate(@Qualifier("mainConfig") RedisConfig config) {
        return RedisUtils.buildRedisTemplate(config);
    }

    @Bean
    @ConfigurationProperties(prefix = "redis.webgroup")
    public RedisConfig webGroupConfig() {
        return new RedisConfig();
    }

    @Bean
    public StringRedisTemplate webGroupRedisTemplate(@Qualifier("webGroupConfig") RedisConfig config) {
        return RedisUtils.buildRedisTemplate(config);
    }


}
