package com.junhua.tornesol.util.pipeline;

public class TestValve extends BaseValve {

    @Override
    public void invoke(Request request, Response response) {
        response.setUriOut(response.getUriOut() + "_test valve_");
        getNext().invoke(request, response);
    }
}
