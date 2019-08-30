package com.ximalaya.webgroup.tdkservice.netty.udp.multi;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class AcceptorHandler extends SimpleChannelInboundHandler<LogMsg> {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogMsg event) throws Exception {

        StringBuilder builder = new StringBuilder();
        builder.append(event.getTime());
        builder.append(" [");
        builder.append(event.getSource().toString());
        builder.append("] ：[");
        builder.append(event.getMsgId());
        builder.append("] ：");
        builder.append(event.getMsg());
        //打印 LogMsg 的数据
        System.out.println(builder.toString());

    }
}
