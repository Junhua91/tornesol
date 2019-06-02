package com.junhua.rpc.transport.netty;

import com.junhua.rpc.demo.ClientDemo;
import com.junhua.rpc.transport.model.Request;
import com.junhua.rpc.transport.model.Response;
import com.junhua.rpc.transport.model.RpcInvocation;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        RpcInvocation invocation = new RpcInvocation();

        Object[] args = {"hello RPC"};
        invocation.setClazz(ClientDemo.class);
        invocation.setMethodName("say");
        invocation.setArguments(args);

        Request request = new Request(12344321);
        request.setRpcInvocation(invocation);

        ctx.writeAndFlush(request);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof Response) {
            Response res = (Response) msg;
            Object result = res.getResult();
            System.out.println(result);
        }
    }
}
