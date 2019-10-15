package com.junhua.http;

import com.junhua.http.api.IHttpResponseHandler;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HttpDemo {

    public static void main(String[] args) {
        WebHttpService<String, String> webHttpService =
                new WebHttpService<>(5, 0, "");

        Map<String, String> params = new HashMap<String, String>() {{
            put("typeCode", "free");
            put("clusterCode", "all");
        }};

        Map<String, String> headers = new HashMap<String, String>() {{
            put("Accept", "*/*");
            put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36");
        }};


        webHttpService.sendGet("https://www.ximalaya.com/revision/rank/v2/element/code",
                params, headers, new IHttpResponseHandler<String>() {
                    @Override
                    public boolean hasError() {
                        return false;
                    }

                    @Override
                    public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                        String result = readResponseBody(response);
                        return "";
                    }
                });
    }
}
