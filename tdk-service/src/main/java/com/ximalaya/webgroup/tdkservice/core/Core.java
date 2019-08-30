package com.ximalaya.webgroup.tdkservice.core;

import com.ximalaya.webgroup.tdkservice.core.redis.RedisAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Core {

    @Autowired
    private RedisAdapter redis;
    @Autowired
    private ThriftAdapter thrift;

    public RedisAdapter getRedis() {
        return redis;
    }

    public ThriftAdapter getThrift() {
        return thrift;
    }
}
