package com.ximalaya.webgroup.tdkservice.netty.websocket.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;

import static io.netty.handler.codec.http.HttpResponseStatus.*;


import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

public class WebSocketServerHttpHandler extends SimpleChannelInboundHandler<FullHttpRequest> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest req) throws Exception {

        if ("/".equals(req.uri()) || "/index.html".equals(req.uri())) {
            String webSocketLocation = getWebSocketLocation(ctx.pipeline(), req, "/websocket");
            ByteBuf content = MakeIndexPage.getContent(webSocketLocation);
            FullHttpResponse res = new DefaultFullHttpResponse(
                    HTTP_1_1, OK, content);
            res.headers().set(HttpHeaderNames.CONTENT_TYPE,
                    "text/html; charset=UTF-8");
            HttpUtil.setContentLength(res, content.readableBytes());
            ctx.channel().writeAndFlush(res);
        }

    }

    private String getWebSocketLocation(ChannelPipeline cp, HttpRequest req, String path) {
        String protocol = "ws";
        return protocol + "://" + req.headers().get(HttpHeaderNames.HOST) + path;
    }
}
