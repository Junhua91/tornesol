package com.ximalaya.webgroup.tdkservice.netty.udp.uni;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class UniServer {

    public void start() throws InterruptedException {

        EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap boot = new Bootstrap();

        try {
            boot.group(group).channel(NioDatagramChannel.class)
                    .handler(new UniServerHandler());

            ChannelFuture future = boot.bind(8086).sync();
            System.out.println("应答服务已启动.....");
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    static public void main(String[] args) throws InterruptedException {
        new UniServer().start();
    }
}
