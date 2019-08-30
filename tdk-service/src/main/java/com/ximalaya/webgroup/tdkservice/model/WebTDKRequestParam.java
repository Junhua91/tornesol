package com.ximalaya.webgroup.tdkservice.model;

import com.ximalaya.webgroup.tdkservice.tdk.api.ITDKRequestParam;

public class WebTDKRequestParam implements ITDKRequestParam {

    private String url;
    private String domain;
    private String pageType;

    public WebTDKRequestParam(String url, String domain, String pageType) {
        this.url = url;
        this.domain = domain;
        this.pageType = pageType;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getPageType() {
        return pageType;
    }

    @Override
    public String getDomain() {
        return domain;
    }

}
