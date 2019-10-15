package com.junhua.tornesol.util.httpclient;

import java.io.IOException;

/**
 * 了解，使用apache下http的相关类
 */
public class HttpClientExample {


    public static void main(String[] args) throws IOException {
        String BAIDU_MIP_PUSH_URL = "https://www.ximalaya.com/revision/rank/v2/element/code?typeCode=free&clusterCode=all";
        Client client = new Client();
        System.out.println(client.get(BAIDU_MIP_PUSH_URL, client.responseHandler));
    }

}
