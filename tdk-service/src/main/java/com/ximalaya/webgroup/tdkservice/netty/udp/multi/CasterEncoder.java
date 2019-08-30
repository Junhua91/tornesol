package com.ximalaya.webgroup.tdkservice.netty.udp.multi;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.util.List;


public class CasterEncoder extends MessageToMessageEncoder<LogMsg> {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, LogMsg msg, List<Object> out) throws Exception {

        byte[] content = msg.getMsg().getBytes(CharsetUtil.UTF_8);

        ByteBuf buf = ctx.alloc().buffer(2 * 8 + content.length + 1);

        buf.writeLong(msg.getMsgId());
        buf.writeLong(msg.getTime());
        buf.writeByte(LogMsg.SEPARATOR);
        buf.writeBytes(content);

        out.add(new DatagramPacket(buf,
                new InetSocketAddress("255.255.255.255", 8087)));
    }
}
