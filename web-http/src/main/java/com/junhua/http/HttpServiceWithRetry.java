package com.junhua.http;

import com.junhua.http.api.IHttpResponseHandler;
import com.junhua.http.exception.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 包含错误重试的HTTP请求
 */
public class HttpServiceWithRetry {

    //默认重试次数为10次
    private final int retryTime;
    private BaseHttpService baseHttpService = new BaseHttpService();
    private Logger LOG = LoggerFactory.getLogger(HttpServiceWithRetry.class);

    public HttpServiceWithRetry(int retryTime) {
        this.retryTime = retryTime;
    }

    public <T> T postWithRetry(
            String url,
            String data,
            Map<String, String> params,
            IHttpResponseHandler<T> responseHandler) {
        Either<T, ? extends Exception> result = null;
        int cnt = 0;

        while (retryTime - cnt >= 0) {
            result = baseHttpService.post(url, params, data, responseHandler);
            if (result.isLeft()) break;
            cnt++;
            LOG.info("{}th time to retry POST request: {} ", cnt, url);
        }
        if (result.isRight()) {
            LOG.error("{}: POST request fails", url);
            return null;
        } else return result.left();
    }


    public <T> T getWithRetry(
            String url,
            Map<String, String> params,
            Map<String, String> headers,
            IHttpResponseHandler<T> responseHandler) {
        Either<T, ? extends Exception> result = null;
        int cnt = 0;
        while (retryTime - cnt >= 0) {

            result = baseHttpService.get(url, params, headers, responseHandler);
            if (result.isLeft()) break;
            cnt++;
            LOG.info("{}th time to retry GET request: {} ", cnt, url);
        }
        if (result.isRight()) {
            LOG.error("{}: GET request fails", url);
            return null;
        } else return result.left();
    }
}
