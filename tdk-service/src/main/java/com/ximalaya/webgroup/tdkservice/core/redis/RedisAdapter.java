package com.ximalaya.webgroup.tdkservice.core.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisAdapter {

    @Autowired
    @Qualifier("mainRedisTemplate")
    private StringRedisTemplate mainRedis;

    @Autowired
    @Qualifier("webGroupRedisTemplate")
    private StringRedisTemplate webRedis;

    public StringRedisTemplate getMainRedis() {
        return mainRedis;
    }

    public StringRedisTemplate getWebRedis() {
        return webRedis;
    }
}
