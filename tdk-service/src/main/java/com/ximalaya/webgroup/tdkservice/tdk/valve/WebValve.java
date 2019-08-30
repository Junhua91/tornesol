package com.ximalaya.webgroup.tdkservice.tdk.valve;


import com.ximalaya.webgroup.tdkservice.model.MetaWeb;
import com.ximalaya.webgroup.tdkservice.tdk.api.SResult;
import com.ximalaya.webgroup.tdkservice.model.TDKRequest;
import com.ximalaya.webgroup.tdkservice.model.TDKResponse;
import com.ximalaya.webgroup.tdkservice.tdk.worker.WebTDKWorker;
import org.springframework.data.redis.core.StringRedisTemplate;

public class WebValve extends BaseValve {

    private StringRedisTemplate redis;

    private WebTDKWorker worker = new WebTDKWorker();


    public WebValve(StringRedisTemplate redis) {
        this.redis = redis;
    }

    @Override
    public void invoke(TDKRequest request, TDKResponse response) {
        worker.setRedis(this.redis);
        SResult<MetaWeb> sResult = worker.prepareResult(response);
        response.setResult(sResult);
    }
}
