package com.junhua.http;

import com.junhua.http.api.IHttpResponseHandler;
import com.junhua.http.exception.Either;
import com.junhua.http.exception.WebHttpException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


/**
 * 封装 GET、POST 方法的发送、异常处理。
 */
public class BaseHttpService {

    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    /**
     * POST 方法
     *
     * @param url
     * @param params
     * @param data:           POST 数据
     * @param responseHandler
     * @param <T>
     * @return
     */
    public <T> Either<T, ? extends Exception> post(String url, Map<String, String> params,
                                                   String data, IHttpResponseHandler<T> responseHandler) {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            url = buildUrl(url, params);
            //创建POST请求
            HttpPost httpPost = new HttpPost(url);
            StringEntity requestEntity = new StringEntity(data, ContentType.create("text/plain", "UTF-8"));
            httpPost.setEntity(requestEntity);
            T result = httpclient.execute(httpPost, responseHandler);
            if (responseHandler.hasError()) {
                return Either.right(new WebHttpException("post returns wrong msg"));
            }
            return Either.left(result);
        } catch (Exception e) {
            LOG.error("Exception happens while posting date: ", e);
            return Either.right(new WebHttpException(e.getMessage()));
        }
    }

    /**
     * GET 方法
     *
     * @param url：请求路由
     * @param params:请求参数
     * @param headers:         请求头
     * @param responseHandler: 回调方法
     * @param <T>
     * @return
     */
    public <T> Either<T, ? extends Exception> get(String url,
                                                  Map<String, String> params,
                                                  Map<String, String> headers,
                                                  IHttpResponseHandler<T> responseHandler) {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            url = buildUrl(url, params);
            //创建GET请求
            HttpGet httpGet = new HttpGet(url);

            //添加请求头
            if (headers != null && !headers.isEmpty()) {
                headers.entrySet().stream().forEach(entry -> {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    httpGet.addHeader(key, value);
                });
            }
            T result = httpclient.execute(httpGet, responseHandler);
            if (responseHandler.hasError()) {
                return Either.right(new WebHttpException("get returns wrong msg"));
            }
            return Either.left(result);
        } catch (Exception e) {
            LOG.error("Exception happens while sending GET: ", e);
            e.printStackTrace();
            return Either.right(new WebHttpException(e.getMessage()));
        }
    }

    private String buildUrl(String url, Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        //拼接参数
        if (!params.isEmpty()) {
            params.entrySet().forEach(entry -> {
                String key = entry.getKey();
                String value = entry.getValue();
                sb.append("&" + key + "=" + value);
            });
            String paramStr = sb.toString().replaceFirst("&", "?");
            url = url + paramStr;
        }
        return url;
    }


}

