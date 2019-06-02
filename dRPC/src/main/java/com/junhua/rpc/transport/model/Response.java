package com.junhua.rpc.transport.model;

public class Response {

    private long id;
    private Object result;

    public Response() {
    }

    public Response(long id) {
        this.id = id;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
