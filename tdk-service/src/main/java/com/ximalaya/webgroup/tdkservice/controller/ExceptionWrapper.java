package com.ximalaya.webgroup.tdkservice.controller;


import com.ximalaya.mainstay.rpc.thrift.TApplicationException;

import java.util.function.Function;

public class ExceptionWrapper {

    public <T, R> R wrapControllerException(Function<T, R> function, T t) throws TApplicationException {
        try {
            return function.apply(t);
        } catch (Throwable throwable) {
            throw new TApplicationException("TDK service is not available");
        }
    }
}
