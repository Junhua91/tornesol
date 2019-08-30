package com.ximalaya.webgroup.tdkservice.tdk.api;

import java.util.Map;

public interface Handler {

    /**
     * 根据已经获取到上下文和传入的参数，获取新的上下文参数
     * @param value
     * @param context
     * @return
     */
    Map<String, String> handle(String value, Map<String, String> context);
}
