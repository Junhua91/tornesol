package com.ximalaya.webgroup.tdkservice.utils;

import com.alibaba.fastjson.JSON;

public class JSONUtils {


    /**
     * 将 JsonString 转换成指定对象
     *
     * @param jsonString
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T parseJson(String jsonString, Class<T> clazz) {
        T result = JSON.parseObject(jsonString, clazz);
        return result;
    }

    /**
     * 将对象转换成 JsonString
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String toJsonString(T obj) {
        if (obj == null) return "";
        return JSON.toJSONString(obj);
    }
}
