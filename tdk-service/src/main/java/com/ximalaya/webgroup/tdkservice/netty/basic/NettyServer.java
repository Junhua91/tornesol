package com.ximalaya.webgroup.tdkservice.netty.basic;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;

import java.net.InetSocketAddress;


public class NettyServer {

    public void start() throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();

        ServerBootstrap boot = new ServerBootstrap();

        NettyServerHandler serverHandler = new NettyServerHandler();

        try {

            boot.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(8083))
                    .childHandler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel socketChannel) throws Exception {
//                            socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,
                                    Unpooled.copiedBuffer("@@".getBytes())));
                            socketChannel.pipeline().addLast(serverHandler);

                        }
                    });

            ChannelFuture future = boot.bind().sync();

            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }

    static public void main(String[] args) throws InterruptedException {
        new NettyServer().start();
    }

}
