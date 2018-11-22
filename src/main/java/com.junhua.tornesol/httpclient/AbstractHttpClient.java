package com.junhua.tornesol.httpclient;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public abstract class AbstractHttpClient {


    /**
     * 发送POST请求
     * @param host
     * @param handler：自定义responseHandler
     * @param <T>
     * @return
     * @throws IOException
     */
    protected <T> T post(String host, ResponseHandler<T> handler) throws IOException {

        CloseableHttpClient httpclient = null;
        try {
            String content = buildContent();
            httpclient = HttpClients.createDefault();
            //创建POST请求
            HttpPost httpPost = new HttpPost(host);
            StringEntity requestEntity = new StringEntity(content, ContentType.create("text/plain", "UTF-8"));
            httpPost.setEntity(requestEntity);
            T result = httpclient.execute(httpPost, handler);
            return result;
        } finally {
            if (httpclient != null) try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 需要发送的信息
     * @return
     */
    protected abstract String buildContent();
}
