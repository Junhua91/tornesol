package com.ximalaya.webgroup.tdkservice.tdk.valve;


import com.ximalaya.webgroup.tdkservice.model.TDKRequest;
import com.ximalaya.webgroup.tdkservice.model.TDKResponse;
import com.ximalaya.webgroup.tdkservice.tdk.api.Handler;

import java.util.HashMap;
import java.util.Map;

/**
 * handler链，用来获取上下文信息
 */
public class ContextValve extends BaseValve {

    private Map<String, Handler> handlerMap;
    private Map<String, String> context = new HashMap<>();

    public ContextValve(Map<String, Handler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public void invoke(TDKRequest request, TDKResponse response) {
        response.setContext(getContext(response.getGroupMap()));
        getNext().invoke(request, response);
    }


    private Map getContext(Map<String, String> groupMap) {
        if (handlerMap == null || handlerMap.isEmpty()) {
            return context;
        }
        handlerMap.entrySet().stream().forEach(entry -> {
            String handlerName = entry.getKey();
            Handler handler = entry.getValue();
            String groupValue = groupMap.get(handlerName);
            handler.handle(groupValue, context);
        });
        return context;
    }
}
