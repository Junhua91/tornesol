package com.junhua.rpc.init.invoker;

import com.junhua.rpc.common.DRpcException;
import com.junhua.rpc.init.proxy.Invoker;
import com.junhua.rpc.transport.model.Request;
import com.junhua.rpc.transport.model.Response;

public abstract class AbstractInvoker<T> implements Invoker<T> {

    private final Class<T> iface;

    public AbstractInvoker(Class<T> iface) {
        this.iface = iface;
    }

    @Override
    public Response invoke(Request request) {
        try {
            return doInvoke(request);
        } catch (Exception e) {
            throw new DRpcException("Invoke " + request + " failed.", e);
        }
    }

    @Override
    public Class<T> getInterface() {
        return iface;
    }

    protected abstract Response doInvoke(Request request) throws Exception;

}
