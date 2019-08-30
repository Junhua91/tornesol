package com.ximalaya.webgroup.tdkservice.netty.protobuf;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;

import java.net.InetSocketAddress;

public class ProtoBufServer {

    public void start() {

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ProtoBufServerHandler handler = new ProtoBufServerHandler();

        ServerBootstrap boot = new ServerBootstrap();
        boot.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(8085))
                .childHandler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
//                        ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
                        ch.pipeline().addLast(new ProtobufDecoder(PersonProto.Person.getDefaultInstance()));
                        ch.pipeline().addLast(handler);
                    }
                });
        try {
            ChannelFuture future = boot.bind().sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    static public void main(String[] args) {
        new ProtoBufServer().start();
    }
}
