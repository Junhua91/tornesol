package com.junhua.rpc.init;

import com.junhua.rpc.transport.netty.NettyServer;
import org.springframework.beans.factory.InitializingBean;

public class ServiceBean<T> implements InitializingBean {

    private T ref;

    public void setRef(T ref) {
        this.ref = ref;
    }

    public T getRef() {
        return ref;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        NettyServer nettyServer = new NettyServer(9700);
        nettyServer.bind();
    }
}
