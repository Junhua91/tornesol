package com.junhua.rpc.transport.support;

import com.junhua.rpc.common.DRpcException;
import com.junhua.rpc.transport.model.Response;

public interface ResponseFuture {

    /**
     * get result.
     *
     * @return result.
     */
    Response get() throws DRpcException;

    /**
     * get result with the specified timeout.
     *
     * @param timeoutInMillis timeout.
     * @return result.
     */
    Response get(int timeoutInMillis) throws DRpcException;

    /**
     * check is done.
     *
     * @return done or not.
     */
    boolean isDone();

}
