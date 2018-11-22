package com.junhua.tornesol.httpclient;

import org.apache.http.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client extends AbstractHttpClient {

    public CustomResponseHandler<String> responseHandler = new CustomResponseHandler<String>() {

        @Override
        protected String handle(HttpResponse response, String urlsToPush) {

            BufferedReader in = null;
            StringBuffer sb = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");

            try {
                in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                while ((line = in.readLine()) != null) {
                    sb.append(line + NL);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null)
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
            System.out.println(sb.toString());
            return sb.toString();
        }
    };

    @Override
    protected String buildContent() {
        return "http://m.ximalaya.com/62322310/album/18835582\n\r";
    }


}
