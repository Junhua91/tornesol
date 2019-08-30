package com.ximalaya.webgroup.tdkservice.tdk.api;

import com.ximalaya.webgroup.tdkservice.tdk.pipeline.Pipeline;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.Map;

/**
 * @param <R>
 */
public interface Container<R> {

    String getDomain();

    Pipeline getPipeline();

    SResult<R> invoke(ITDKRequestParam request);

    void init();

    void setGroupNameList(List<String> groupNameList);

    void setHandlerMap(Map<String, Handler> handlerMap);

    void setRedis(StringRedisTemplate redis);
}
