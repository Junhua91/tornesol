package com.ximalaya.webgroup.tdkservice.model;

import com.ximalaya.webgroup.tdkservice.tdk.api.SResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TDKResponse {

    private String uriIn;
    private String uriOut;
    private int ret;
    private String msg;
    private Map<String, String> context = new HashMap<>();
    private Map<String, String> groupMap = new HashMap<>();
    private List<String> uniqueCodes = new ArrayList<>();
    private SResult<MetaWeb> result;

    public String getUriIn() {
        return uriIn;
    }

    public void setUriIn(String uriIn) {
        this.uriIn = uriIn;
    }

    public String getUriOut() {
        return uriOut;
    }

    public void setUriOut(String uriOut) {
        this.uriOut = uriOut;
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

    public Map<String, String> getContext() {
        return context;
    }

    public void setContext(Map<String, String> context) {
        this.context = context;
    }

    public List<String> getUniqueCodes() {
        return uniqueCodes;
    }

    public void setUniqueCodes(List<String> uniqueCodes) {
        this.uniqueCodes = uniqueCodes;
    }

    public SResult<MetaWeb> getResult() {
        return result;
    }

    public void setResult(SResult<MetaWeb> result) {
        this.result = result;
    }

    public Map<String, String> getGroupMap() {
        return groupMap;
    }

    public void setGroupMap(Map<String, String> groupMap) {
        this.groupMap = groupMap;
    }
}
