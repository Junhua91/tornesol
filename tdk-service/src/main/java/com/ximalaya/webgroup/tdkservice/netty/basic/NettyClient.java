package com.ximalaya.webgroup.tdkservice.netty.basic;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;

import java.net.InetSocketAddress;

public class NettyClient {

    public void start() throws InterruptedException {

        EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap boot = new Bootstrap();

        try {
            boot.group(group)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress("127.0.0.1", 8083))
                    .handler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            ch.pipeline().addLast(new NettyClientHandler());
                        }
                    });

            ChannelFuture future = boot.connect().sync();// 阻塞等待，直到连接完成

            future.channel().closeFuture().sync();//阻塞等待，直到关闭完成
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new NettyClient().start();
    }


}
