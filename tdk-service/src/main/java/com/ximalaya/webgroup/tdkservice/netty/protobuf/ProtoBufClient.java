package com.ximalaya.webgroup.tdkservice.netty.protobuf;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

import java.net.InetSocketAddress;

public class ProtoBufClient {

    public void start() throws InterruptedException {

        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap boot = new Bootstrap();

        try {
            boot.group(group).channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress("127.0.0.1", 8085))
                    .handler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
//                            ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
                            ch.pipeline().addLast(new ProtobufEncoder());
                            ch.pipeline().addLast(new ProtoBufClientHandler());
                        }
                    });
            ChannelFuture future = boot.connect().sync();
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    static public void main(String[] args) throws InterruptedException {
        new ProtoBufClient().start();
    }
}
