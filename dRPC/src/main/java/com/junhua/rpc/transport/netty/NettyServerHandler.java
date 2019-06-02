package com.junhua.rpc.transport.netty;

import com.junhua.rpc.transport.model.Request;
import com.junhua.rpc.transport.model.Response;
import com.junhua.rpc.transport.model.RpcInvocation;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        if (msg instanceof Request) {
            Response response;
            response = doInvocation((Request) msg);
            ctx.writeAndFlush(response);
        }
    }

    private Response doInvocation(Request request) throws IllegalAccessException,
            InstantiationException, InvocationTargetException {
        RpcInvocation invocation = request.getRpcInvocation();
        Class targetClass = invocation.getClazz();
        Object obj = targetClass.newInstance();
        Method[] methods = targetClass.getDeclaredMethods();
        Object res = null;
        for (Method method : methods) {
            if (method.getName().equals(invocation.getMethodName())) {
                res = method.invoke(obj, invocation.getArguments());
            }
        }
        Response response = new Response(request.getId());
        response.setResult(res);
        return response;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
