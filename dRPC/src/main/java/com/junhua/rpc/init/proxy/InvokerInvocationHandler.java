package com.junhua.rpc.init.proxy;


import com.junhua.rpc.transport.model.Request;
import com.junhua.rpc.transport.model.RpcInvocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * 调用过程动态代理
 */
public class InvokerInvocationHandler implements InvocationHandler {

    private Invoker<?> invoker;

    public InvokerInvocationHandler(Invoker<?> invoker) {
        this.invoker = invoker;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Request request = buildRequest(proxy, method, args);
        return invoker.invoke(request);
    }


    private Request buildRequest(Object proxy, Method method, Object[] args) throws ClassNotFoundException {
        String methodName = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        RpcInvocation invocation = new RpcInvocation();
        invocation.setClazz(invoker.getInterface());
        invocation.setParameterTypes(parameterTypes);
        invocation.setArguments(args);
        invocation.setMethodName(methodName);
        Request request = new Request();
        request.setId(UUID.randomUUID().node());
        request.setRpcInvocation(invocation);
        return request;
    }
}
