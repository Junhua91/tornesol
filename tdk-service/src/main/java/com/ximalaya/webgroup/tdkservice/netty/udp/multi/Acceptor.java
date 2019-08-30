package com.ximalaya.webgroup.tdkservice.netty.udp.multi;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class Acceptor {

    public void run() throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap boot = new Bootstrap();
        try {
            boot.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .option(ChannelOption.SO_REUSEADDR,true)
                    .handler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            ch.pipeline().addLast(new AcceptorDecoder());
                            ch.pipeline().addLast(new AcceptorHandler());
                        }
                    });

            ChannelFuture future = boot.bind(8087).sync();
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Acceptor().run();
    }
}
