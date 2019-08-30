package com.ximalaya.webgroup.tdkservice.netty.protocol;

import com.ximalaya.webgroup.tdkservice.netty.protocol.model.BusinessTypeEnum;
import com.ximalaya.webgroup.tdkservice.netty.protocol.model.MessageProto;
import com.ximalaya.webgroup.tdkservice.netty.protocol.utils.MessageUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public abstract class CustomHandler extends ChannelInboundHandlerAdapter {

    protected static final Logger LOG = LoggerFactory.getLogger(CustomHandler.class);
    private String name;

    public CustomHandler(String name) {
        this.name = name;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        MessageProto.messageProto message = (MessageProto.messageProto) msg;

        if (message.getHeader().getType() == BusinessTypeEnum.HEARTBEAT_REQ.getType()) {
            LOG.info(name + " get PING from " + ctx.channel().remoteAddress());
            sendPongMsg(ctx);
        } else if (message.getHeader().getType() == BusinessTypeEnum.HEARTBEAT_RESP.getType()) {
            LOG.info(name + " get PONG from " + ctx.channel().remoteAddress());
        } else {
            handleData(ctx, msg);
        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            switch (e.state()) {
                case READER_IDLE:
                    handleReaderIdle(ctx);
                    break;
                case WRITER_IDLE:
                    handleWriterIdle(ctx);
                    break;
                case ALL_IDLE:
                    handleAllIdle(ctx);
                    break;
            }
        }
    }

    abstract protected void handleData(ChannelHandlerContext ctx, Object msg);

    protected void sendPingMsg(ChannelHandlerContext ctx) {
        Map<String, String> attachment = new HashMap<String, String>() {
            {
                put("心跳key1", "心跳value1");
            }
        };
        MessageProto.messageProto message = MessageUtils.createMessage(
                2, 0xedfedL, BusinessTypeEnum.HEARTBEAT_REQ,
                33333, attachment, "心跳请求"
        );
        ctx.writeAndFlush(message);
    }


    protected void sendPongMsg(ChannelHandlerContext ctx) {
        Map<String, String> attachment = new HashMap<String, String>() {
            {
                put("心跳key2", "心跳value2");
            }
        };
        MessageProto.messageProto message = MessageUtils.createMessage(
                2, 0xedfffL, BusinessTypeEnum.HEARTBEAT_RESP,
                5555, attachment, "心跳应答"
        );
        ctx.writeAndFlush(message);
    }

    protected void handleReaderIdle(ChannelHandlerContext ctx) {
        LOG.error("---READER_IDLE---");
    }

    protected void handleWriterIdle(ChannelHandlerContext ctx) {
        LOG.error("---WRITER_IDLE---");
    }

    protected void handleAllIdle(ChannelHandlerContext ctx) {
        LOG.error("---ALL_IDLE---");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
