package com.junhua.rpc.init.proxy;


import com.junhua.rpc.transport.model.Request;
import com.junhua.rpc.transport.model.Response;

public interface Invoker<T> {

    /**
     * get service interface.
     *
     * @return service interface.
     */
    Class<T> getInterface();


    /**
     * @param request
     * @return
     */
    Response invoke(Request request);

}
