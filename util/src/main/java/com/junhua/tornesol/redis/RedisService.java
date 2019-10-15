package com.junhua.tornesol.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

//@Service
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    public String getValue(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }
}
