package com.ximalaya.webgroup.tdkservice.m3.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler<T> implements InvocationHandler {

    private T target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before");
        Object result = method.invoke(target, args);
        System.out.println("after");

        return result;
    }

    public T getTarget() {
        return target;
    }

    public void setTarget(T target) {
        this.target = target;
    }
}
