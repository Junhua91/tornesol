package com.ximalaya.webgroup.tdkservice.netty.udp.multi;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

public class AcceptorDecoder extends MessageToMessageDecoder<DatagramPacket> {


    @Override
    protected void decode(ChannelHandlerContext ctx, DatagramPacket msg, List<Object> out) throws Exception {

        ByteBuf buf = msg.content();

        Long msgId = buf.readLong();
        Long time = buf.readLong();
        byte sep = buf.readByte();

        int index = buf.readerIndex();

        String sendMsg = buf.slice(index, buf.readableBytes()).toString(CharsetUtil.UTF_8);
        LogMsg event = new LogMsg(msg.sender(), sendMsg, msgId, time);
        out.add(event);
    }
}
