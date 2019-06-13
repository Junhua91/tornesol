package com.junhua.rpc.transport.netty;


import com.junhua.rpc.transport.codec.KryoDecoder;
import com.junhua.rpc.transport.codec.KryoEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

/**
 *
 */
public class NettyServer {

    private final int port;

    public NettyServer(int port) {
        this.port = port;
    }

    public void bind() {

        ServerBootstrap boot = new ServerBootstrap();
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            boot.group(group)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(
                            new ChannelInitializer<SocketChannel>() {
                                @Override
                                protected void initChannel(SocketChannel ch) throws Exception {
                                    ch.pipeline().addLast("frameDecoder", new LengthFieldBasedFrameDecoder(65535, 0, 2, 0, 2));
                                    ch.pipeline().addLast("frameEncoder", new LengthFieldPrepender(2));
                                    ch.pipeline().addLast(new KryoDecoder());
                                    ch.pipeline().addLast("MessageEncoder", new KryoEncoder());
                                    ch.pipeline().addLast(new NettyServerHandler());
                                }
                            });

            ChannelFuture future = boot.bind(9700).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                group.shutdownGracefully().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
