package com.junhua.rpc.transport.netty;

import com.junhua.rpc.common.DRpcException;
import com.junhua.rpc.transport.model.Response;
import com.junhua.rpc.transport.support.DefaultFuture;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


public class NettyClientHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof Response) {
            Response res = (Response) msg;
            handleResponse(ctx.channel(), res);
        }
    }

    /**
     * 发送数据到DefaultFuture：支持异步获取数据
     *
     * @param channel
     * @param response
     * @throws DRpcException
     */
    static void handleResponse(Channel channel, Response response) throws DRpcException {
        if (response != null) {
            DefaultFuture.received(channel, response);
        }
    }

}
