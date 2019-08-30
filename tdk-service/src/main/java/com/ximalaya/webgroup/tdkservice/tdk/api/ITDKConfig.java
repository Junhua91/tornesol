package com.ximalaya.webgroup.tdkservice.tdk.api;

import org.springframework.data.redis.core.StringRedisTemplate;

public interface ITDKConfig<R> {

    /**
     * 返回TDK 结果
     *
     * @return
     */
    R getResult();

    /**
     * 注入redis
     *
     * @return
     */
    StringRedisTemplate getRedis();


    /**
     * 创建Container的传入参数
     *
     * @return
     */
    ITDKRequestParam buildRequest();


    /**
     * 设置项目的Container
     */
    Container getContainer();
}
