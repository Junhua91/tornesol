package com.junhua.rpc.init.proxy;

import java.lang.reflect.Proxy;


/**
 *
 */
public class JdkProxyFactory implements ProxyFactory {

    @Override
    public <T> T getProxy(Invoker<T> invoker) {
        return (T) Proxy
                .newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{invoker.getInterface()},
                        new InvokerInvocationHandler(invoker));
    }
}
