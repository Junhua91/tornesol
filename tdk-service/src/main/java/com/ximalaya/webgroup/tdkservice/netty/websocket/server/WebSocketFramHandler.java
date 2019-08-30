package com.ximalaya.webgroup.tdkservice.netty.websocket.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebSocketFramHandler extends SimpleChannelInboundHandler<WebSocketFrame> {

    private ChannelGroup channelGroup;

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    public WebSocketFramHandler(ChannelGroup channelGroup) {
        this.channelGroup = channelGroup;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame msg) throws Exception {
        if (msg instanceof TextWebSocketFrame) {
            String text = ((TextWebSocketFrame) msg).text();
            channelGroup.writeAndFlush(new TextWebSocketFrame(text));
        } else LOG.error("unsupported message type");
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx,
                                   Object evt) throws Exception {
        /*检测事件，如果是握手成功事件，做点业务处理*/
        if (evt == WebSocketServerProtocolHandler
                .ServerHandshakeStateEvent.HANDSHAKE_COMPLETE) {

            //通知所有已经连接的 WebSocket 客户端新的客户端已经连接上了
            channelGroup.writeAndFlush(new TextWebSocketFrame(
                    "Client " + ctx.channel() + " joined"));

            //将新的 WebSocket Channel 添加到 ChannelGroup 中，
            // 以便它可以接收到所有的消息
            channelGroup.add(ctx.channel());
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }
}
