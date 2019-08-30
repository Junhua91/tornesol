package com.ximalaya.webgroup.tdkservice.utils;

import com.ximalaya.webgroup.tdkservice.core.redis.RedisConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {

    private static Logger logger = LoggerFactory.getLogger(RedisUtils.class);


    static public StringRedisTemplate buildRedisTemplate(RedisConfig param) {
        RedisStandaloneConfiguration redisConf = new RedisStandaloneConfiguration(param.getHost(), param.getPort());
        redisConf.setDatabase(param.getDb());
        redisConf.setPassword(RedisPassword.of(param.getPassword()));

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(param.getMaxTotal());
        poolConfig.setMinIdle(param.getMinIdle());
        poolConfig.setMaxWaitMillis(param.getTimeout());

        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jpcb = (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
        jpcb.poolConfig(poolConfig);
        JedisClientConfiguration jedisClientConfiguration = jpcb.build();

        JedisConnectionFactory factory = new JedisConnectionFactory(redisConf, jedisClientConfiguration);

        return new StringRedisTemplate(factory);
    }




}
