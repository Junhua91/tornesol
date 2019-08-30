package com.ximalaya.webgroup.tdkservice.netty.udp.uni;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

public class UniClient {

    public void start() throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap boot = new Bootstrap();

        try {
            boot.group(group).channel(NioDatagramChannel.class)
                    .handler(new UniClientHandler());

            Channel ch = boot.bind(0).sync().channel();

            ByteBuf sendBuf = Unpooled.copiedBuffer("hi server", CharsetUtil.UTF_8);
            ch.writeAndFlush(new DatagramPacket(sendBuf, new InetSocketAddress("127.0.0.1", 8086)));

            if(!ch.closeFuture().await(15000)){
                System.out.println("查询超时！");
            }
        } finally {
            group.shutdownGracefully();
        }
    }

    static public void main(String[] args) throws InterruptedException {
        new UniClient().start();
    }
}
