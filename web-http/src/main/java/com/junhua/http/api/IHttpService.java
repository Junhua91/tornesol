package com.junhua.http.api;

import java.util.Map;

/**
 * 定义POST, GET 接口
 */
public interface IHttpService<T> {

    /**
     * GET 方法
     *
     * @param url：请求路由
     * @param params:请求参数
     * @param responseHandler: 回调方法
     * @return
     */
    T sendGet(String url, Map<String, String> params,
              IHttpResponseHandler<T> responseHandler) throws Exception;

    /**
     * POST 方法
     *
     * @param url
     * @param params
     * @param responseHandler
     * @return
     */
    T sendPost(String url, Map<String, String> params, IDataProvider dataProvider,
               IHttpResponseHandler<T> responseHandler) throws Exception;
}
