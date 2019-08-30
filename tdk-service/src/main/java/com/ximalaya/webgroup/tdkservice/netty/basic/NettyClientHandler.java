package com.ximalaya.webgroup.tdkservice.netty.basic;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

public class NettyClientHandler extends SimpleChannelInboundHandler<ByteBuf> {


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf)
            throws Exception {
        System.out.println("客户端收到消息：" + byteBuf.toString(Charset.forName("UTF-8")));
    }

    //通道准备好后，可以开始发送数据
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 100; i++) {
            String sendMsg = "hello netty" + "@@";
            ByteBuf sendBuf = Unpooled.buffer(sendMsg.length());
            sendBuf.writeBytes(sendMsg.getBytes());
            ctx.writeAndFlush(sendBuf);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
