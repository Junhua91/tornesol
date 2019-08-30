package com.ximalaya.webgroup.tdkservice.netty.protocol.client;

import com.google.protobuf.InvalidProtocolBufferException;
import com.ximalaya.webgroup.tdkservice.netty.protocol.CustomHandler;
import com.ximalaya.webgroup.tdkservice.netty.protocol.model.MessageProto;
import io.netty.channel.ChannelHandlerContext;

public class NettyClientHandler extends CustomHandler {

    public NettyClientHandler() {
        super("client");
    }

    @Override
    protected void handleData(ChannelHandlerContext ctx, Object msg) {
        MessageProto.messageProto message = (MessageProto.messageProto) msg;
        MessageProto.messageProto.Builder builder = MessageProto.messageProto.newBuilder();
        MessageProto.headerProto header = null;
        try {
            header = MessageProto.headerProto.parseFrom(message.getHeader().toByteArray());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        builder.setHeader(header);
        builder.setBody("客户端发出的消息");
        LOG.info("客户端收到消息：" + message.getBody());
        ctx.writeAndFlush(message);
    }

    @Override
    protected void handleAllIdle(ChannelHandlerContext ctx) {
        super.handleAllIdle(ctx);
        sendPingMsg(ctx);
    }
}
