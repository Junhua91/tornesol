package com.junhua.http.api;

import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

import java.io.IOException;
import java.io.InputStream;

public interface IHttpResponseHandler<T> extends ResponseHandler<T> {

    /**
     * 根据返回结果判断是否有错
     *
     * @return
     */
    boolean hasError();

    /**
     * 读取http 返回结果
     *
     * @param httpResponse
     * @return
     */
    default String readResponseBody(HttpResponse httpResponse) {
        StringBuilder sb = new StringBuilder();
        try (InputStream in = httpResponse.getEntity().getContent()) {
            byte[] b = new byte[1024];
            for (int n; (n = in.read(b)) != -1; ) {
                sb.append(new String(b, 0, n));
            }
        } catch (IOException e) {
            return null;
        }
        return sb.toString();
    }


}
