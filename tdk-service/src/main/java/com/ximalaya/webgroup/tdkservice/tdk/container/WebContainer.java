package com.ximalaya.webgroup.tdkservice.tdk.container;

import com.ximalaya.webgroup.tdkservice.model.*;
import com.ximalaya.webgroup.tdkservice.tdk.api.ITDKRequestParam;
import com.ximalaya.webgroup.tdkservice.tdk.api.SResult;
import com.ximalaya.webgroup.tdkservice.tdk.valve.*;

import java.util.Arrays;
import java.util.List;

public class WebContainer extends BaseContainer<MetaWeb> {

    @Override
    public String getDomain() {
        return "web";
    }

    @Override
    public SResult<MetaWeb> invoke(ITDKRequestParam request) {

        TDKRequest req = new TDKRequest();
        req.setDomain(getDomain());
        req.setUri(request.getUrl());
        req.setUniqueCode("m_share_album_page");

        TDKResponse response = new TDKResponse();

        pipeline.getFirst().invoke(req, response);

        return response.getResult();
    }

    /**
     * 按照list顺序来执行valve
     * @return
     */
    @Override
    public List<Valve> getValveList() {
        UrlValve urlValve = new UrlValve(groupNameList);
        UniqueCodeValve uniqueCodeValve = new UniqueCodeValve();
        ContextValve contextValve = new ContextValve(handlerMap);
        WebValve webValve = new WebValve(this.redis);
        return Arrays.asList(urlValve, uniqueCodeValve, contextValve, webValve);
    }
}
