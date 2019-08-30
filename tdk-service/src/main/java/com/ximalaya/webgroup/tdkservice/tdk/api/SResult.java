package com.ximalaya.webgroup.tdkservice.tdk.api;

public class SResult<R> {

    private R data;
    private int ret;
    private String msg;

    public R getData() {
        return data;
    }

    public void setData(R data) {
        this.data = data;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
