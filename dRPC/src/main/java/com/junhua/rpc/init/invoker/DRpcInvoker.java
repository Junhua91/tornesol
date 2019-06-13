package com.junhua.rpc.init.invoker;

import com.junhua.rpc.transport.model.Request;
import com.junhua.rpc.transport.model.Response;
import com.junhua.rpc.transport.netty.NettyClient;
import com.junhua.rpc.transport.support.DefaultFuture;

import java.net.ConnectException;

public class DRpcInvoker<T> extends AbstractInvoker<T> {

    private NettyClient client;

    public DRpcInvoker(Class<T> iface) {
        super(iface);
        initClient();
    }

    @Override
    protected Response doInvoke(Request request) throws Exception {
        DefaultFuture future = new DefaultFuture(request, client.getChannel(), 2000);
        try {
            client.sendMessage(request);
        } catch (ConnectException e) {
            future.cancel();
            throw e;
        }
        return future.get();
    }

    private void initClient() {
        client = new NettyClient("127.0.0.1", 9700);
        try {
            client.open();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
