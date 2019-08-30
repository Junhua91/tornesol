package com.ximalaya.webgroup.tdkservice.netty.protocol.server;

import com.google.protobuf.InvalidProtocolBufferException;
import com.ximalaya.webgroup.tdkservice.netty.protocol.CustomHandler;
import com.ximalaya.webgroup.tdkservice.netty.protocol.model.MessageProto;
import io.netty.channel.ChannelHandlerContext;

public class MessageServerHandler extends CustomHandler {

    public MessageServerHandler() {
        super("server");
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
        builder.setBody("服务端发出的消息");
        LOG.info("客户端发来的信息：" + message.getBody());
    }

    @Override
    protected void handleReaderIdle(ChannelHandlerContext ctx) {
        super.handleReaderIdle(ctx);
        LOG.error("--client " + ctx.channel().remoteAddress() + " read time out");
        ctx.close();
    }
}
