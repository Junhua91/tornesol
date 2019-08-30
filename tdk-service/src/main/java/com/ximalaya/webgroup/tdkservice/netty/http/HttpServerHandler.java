package com.ximalaya.webgroup.tdkservice.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

@ChannelHandler.Sharable
public class HttpServerHandler extends ChannelInboundHandlerAdapter {

    public void sendMsg(String content, ChannelHandlerContext ctx, HttpResponseStatus status) {
        ByteBuf sendBuf = Unpooled.copiedBuffer(content, CharsetUtil.UTF_8);
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, status, sendBuf);


        response.headers().add(HttpHeaderNames.CONTENT_TYPE, "text/plain;charset=UTF-8");
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        FullHttpRequest request = (FullHttpRequest) msg;
        String path = request.uri();

        if (request.method() == HttpMethod.GET) {
            sendMsg("服务端收到请求", ctx, HttpResponseStatus.OK);
        } else {
            sendMsg("bad request", ctx, HttpResponseStatus.BAD_REQUEST);
        }
    }
}
