package com.ximalaya.webgroup.tdkservice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class CacheUtils<T> {

    private final Class<T> type;

    public CacheUtils(Class<T> type) {
        this.type = type;
    }

    private static Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    public void storeToRedis(String key, T value, StringRedisTemplate redis, int expire) {
        redis.opsForValue().set(key, JSONUtils.toJsonString(value), expire, TimeUnit.MINUTES);
    }

    /**
     * 从redis缓存中获取数据并转换成对象
     *
     * @param key
     * @param redis
     * @param function
     * @param param
     * @return
     */
    public T getFromRedis(String key, StringRedisTemplate redis, Function<Object, T> function, Object param) {
        String redisValue = redis.opsForValue().get(key);

        if (redisValue == null) {
            if (function == null) {
                logger.error("can't get value from redis, please set a function to get value from");
                throw new NoSuchElementException("no value found in redis for the key: " + key);
            }
            T obj = function.apply(param);
            storeToRedis(key, obj, redis, 30);
            return obj;
        } else {
            return JSONUtils.parseJson(redisValue, type);
        }

    }

}
