package com.junhua.http;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.RateLimiter;
import com.junhua.http.api.IDataProvider;
import com.junhua.http.api.IHttpResponseHandler;
import com.junhua.http.exception.WebHttpException;
import com.junhua.mustache.MustacheModel;
import com.junhua.mustache.MustacheWorker;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;


public class WebHttpService<T, R> {

    //重试次数
    final private int retryTime;
    //数据partition的size
    final private int partitionSize;
    //mustache 模版所在的path
    final private String templatePath;

    private final ForkJoinPool forkJoinPool = new ForkJoinPool(5);
    private MustacheWorker<T> mustacheWorker;
    private HttpServiceWithRetry httpServiceWithRetry;
    private RateLimiter rateLimiter = RateLimiter.create(100);

    public WebHttpService(int retryTime,
                          int partitionSize,
                          String templatePath) {
        this.partitionSize = partitionSize;
        this.retryTime = retryTime;
        this.templatePath = templatePath;
        this.httpServiceWithRetry = new HttpServiceWithRetry(this.retryTime);
        this.mustacheWorker = new MustacheWorker<>(templatePath);
    }

    public R sendGet(String url, Map<String, String> params, Map<String, String> headers, IHttpResponseHandler<R> responseHandler) {
        return httpServiceWithRetry.getWithRetry(url, params, headers, responseHandler);
    }

    public void sendPost(String url,
                         String templateName,
                         Map<String, String> params,
                         IDataProvider dataProvider,
                         IHttpResponseHandler<R> responseHandler) throws WebHttpException {
        if (dataProvider == null) {
            throw new WebHttpException("no data provider is configured");
        }
        List<List<T>> dataPartitioned = Lists.partition(dataProvider.provide(), partitionSize);
        rateLimiter.acquire();
        for (List<T> dataList : dataPartitioned) {
            String postData = buildData(dataList, templateName);
            httpServiceWithRetry.postWithRetry(url, postData, params, responseHandler);
        }
    }

    private String buildData(List<T> datas, String templateName) {
        int len = datas.size();
        MustacheModel<T> model = new MustacheModel(datas.subList(0, len - 1), datas.subList(len - 1, len));
        String postData = mustacheWorker.mergeMustache(model, templateName);
        return postData;
    }
}
