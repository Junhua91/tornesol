package com.junhua.rpc.init.proxy;

public interface ProxyFactory {


    /**
     * get proxy for consumer
     *
     * @param invoker 调用器
     * @param <T>     类型
     * @return proxy
     */
    <T> T getProxy(Invoker<T> invoker);

}
