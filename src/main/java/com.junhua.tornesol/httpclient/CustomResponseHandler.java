package com.junhua.tornesol.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

import java.io.IOException;

public abstract class CustomResponseHandler<T> implements ResponseHandler<T> {

    //后续处理response需要的参数
    private String urlsToPush;

    public T handleResponse(HttpResponse response) throws IOException {
        return handle(response, urlsToPush);
    }

    protected abstract T handle(HttpResponse response, String urlsToPush);

    public void setUrlsToPush(String urlsToPush) {
        this.urlsToPush = urlsToPush;
    }
}
