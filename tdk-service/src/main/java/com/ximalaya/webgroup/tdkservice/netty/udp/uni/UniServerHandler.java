package com.ximalaya.webgroup.tdkservice.netty.udp.uni;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

public class UniServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
        String content = msg.content().toString(CharsetUtil.UTF_8);
        System.out.println("客户端请求：" + content);
        if (content.startsWith("hi")) {
            ByteBuf sendBuf = Unpooled.copiedBuffer("welcome to netty", CharsetUtil.UTF_8);
            DatagramPacket packet = new DatagramPacket(sendBuf, msg.sender());
            ctx.writeAndFlush(packet);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
