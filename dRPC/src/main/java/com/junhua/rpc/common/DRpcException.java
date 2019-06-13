package com.junhua.rpc.common;

public class DRpcException extends RuntimeException {

    public DRpcException() {
    }

    public DRpcException(String message) {
        super(message);
    }

    public DRpcException(String message, Throwable cause) {
        super(message, cause);
    }

    public DRpcException(Throwable cause) {
        super(cause);
    }

    public DRpcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
