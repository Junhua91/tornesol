package com.junhua.tornesol.util.pipeline;

public class BasicValve extends BaseValve {


    @Override
    public void invoke(Request request, Response response) {
        String uri = request.uri;
        String uriOut = response.getUriOut() + "_" + uri + request.domain;
        response.setUriIn(uri);
        response.setUriOut(uriOut);
    }
}
