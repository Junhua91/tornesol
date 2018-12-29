package com.junhua.tornesol.util.pipeline;

public class Response {

    private String uriOut;
    private String uriIn;


    public Response() {
    }

    public Response(String uriOut, String uriIn) {
        this.uriOut = uriOut;
        this.uriIn = uriIn;
    }

    public String getUriOut() {
        return uriOut;
    }

    public void setUriOut(String uriOut) {
        this.uriOut = uriOut;
    }

    public String getUriIn() {
        return uriIn;
    }

    public void setUriIn(String uriIn) {
        this.uriIn = uriIn;
    }
}
