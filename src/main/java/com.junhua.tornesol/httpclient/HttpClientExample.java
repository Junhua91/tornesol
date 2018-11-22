package com.junhua.tornesol.httpclient;

import java.io.IOException;

/**
 * 了解，使用apache下http的相关类
 */
public class HttpClientExample {


    public static void main(String[] args) throws IOException {
        String BAIDU_MIP_PUSH_URL = "http://data.zz.baidu.com/urls?appid=1577215662899670&token=9T5FFiRQ8TzB3FcF&type=realtime";
        Client client = new Client();
        System.out.println(client.post(BAIDU_MIP_PUSH_URL, client.responseHandler));
    }

}
