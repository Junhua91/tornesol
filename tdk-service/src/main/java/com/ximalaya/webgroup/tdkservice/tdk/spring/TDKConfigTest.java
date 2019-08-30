package com.ximalaya.webgroup.tdkservice.tdk.spring;


import com.ximalaya.webgroup.tdkservice.model.MetaWeb;
import com.ximalaya.webgroup.tdkservice.tdk.api.SResult;
import com.ximalaya.webgroup.tdkservice.model.WebTDKRequestParam;
import com.ximalaya.webgroup.tdkservice.tdk.api.Container;
import com.ximalaya.webgroup.tdkservice.tdk.api.ITDKConfig;
import com.ximalaya.webgroup.tdkservice.tdk.api.annotation.TDKConfig;
import com.ximalaya.webgroup.tdkservice.tdk.container.WebContainer;
import com.ximalaya.webgroup.tdkservice.tdk.handler.Test1Handler;
import com.ximalaya.webgroup.tdkservice.tdk.api.annotation.TDKHandler;
import com.ximalaya.webgroup.tdkservice.tdk.api.annotation.TDKResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;


@TDKConfig(domain = "test")
@Component
public class TDKConfigTest implements ITDKConfig<SResult<MetaWeb>> {

    @TDKHandler(name = "album")
    private Test1Handler t1;

    @TDKResult
    private SResult<MetaWeb> result;

    @Override
    public SResult<MetaWeb> getResult() {
        return result;
    }

    @Override
    public StringRedisTemplate getRedis() {
        return mainRedis;
    }

    @Override
    public WebTDKRequestParam buildRequest() {
        return new WebTDKRequestParam("/yule/243433/854003/", "web", "album");
    }

    @Override
    public Container getContainer() {
        return new WebContainer();
    }

    @Autowired
    @Qualifier("mainRedisTemplate")
    private StringRedisTemplate mainRedis;


}
