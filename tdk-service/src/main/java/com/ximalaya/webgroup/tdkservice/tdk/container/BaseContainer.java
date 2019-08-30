package com.ximalaya.webgroup.tdkservice.tdk.container;

import com.ximalaya.webgroup.tdkservice.tdk.api.Container;
import com.ximalaya.webgroup.tdkservice.tdk.api.Handler;
import com.ximalaya.webgroup.tdkservice.tdk.pipeline.Pipeline;
import com.ximalaya.webgroup.tdkservice.tdk.pipeline.StandardPipeline;
import com.ximalaya.webgroup.tdkservice.tdk.valve.BasicValve;
import com.ximalaya.webgroup.tdkservice.tdk.valve.Valve;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.Map;

public abstract class BaseContainer<R> implements Container<R> {

    protected List<String> groupNameList;
    protected Map<String, Handler> handlerMap;
    protected StringRedisTemplate redis;

    protected Pipeline pipeline = new StandardPipeline();

    @Override
    public Pipeline getPipeline() {
        return pipeline;
    }

    @Override
    public void init() {
        BasicValve basicValve = new BasicValve();
        pipeline.setBasic(basicValve);

        getValveList().forEach(valve -> pipeline.addValve(valve));
    }

    @Override
    public void setGroupNameList(List<String> groupNameList) {
        this.groupNameList = groupNameList;
    }

    @Override
    public void setHandlerMap(Map<String, Handler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public void setRedis(StringRedisTemplate redis) {
        this.redis = redis;
    }

    public abstract List<Valve> getValveList();
}
