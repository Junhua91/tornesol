package com.junhua.rpc.transport.model;

/**
 * 客户端向服务端发出的请求数据：包含调用方法所需要的参数
 */
public class Request {

    private long id;
    private RpcInvocation rpcInvocation;


    public Request() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public Request(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public RpcInvocation getRpcInvocation() {
        return rpcInvocation;
    }

    public void setRpcInvocation(RpcInvocation rpcInvocation) {
        this.rpcInvocation = rpcInvocation;
    }
}
