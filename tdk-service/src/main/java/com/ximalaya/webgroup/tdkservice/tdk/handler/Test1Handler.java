package com.ximalaya.webgroup.tdkservice.tdk.handler;

import com.ximalaya.webgroup.tdkservice.tdk.api.Handler;

import java.util.Map;

public class Test1Handler implements Handler {

    @Override
    public Map<String, String> handle(String value, Map<String, String> context) {
        context.put("album", "albumTest");
        return context;
    }
}
