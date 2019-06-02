package com.junhua.rpc.transport.netty;

import com.junhua.rpc.transport.codec.KryoDecoder;
import com.junhua.rpc.transport.codec.KryoEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

public class NettyClient {

    private NioEventLoopGroup workGroup = new NioEventLoopGroup();
    private Channel channel;
    private Bootstrap bootstrap;

    public void start() {

        bootstrap = new Bootstrap();
        bootstrap.group(workGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast("frameDecoder", new LengthFieldBasedFrameDecoder(65535, 0, 2, 0, 2));
                        ch.pipeline().addLast("frameEncoder", new LengthFieldPrepender(2));
                        ch.pipeline().addLast(new KryoDecoder());
                        ch.pipeline().addLast("MessageEncoder", new KryoEncoder());
                        ch.pipeline().addLast(new NettyClientHandler());
                    }
                });
    }

    public void connect() {

        if (channel != null && channel.isActive()) return;

        ChannelFuture future = bootstrap.connect(new InetSocketAddress("127.0.0.1", 9500));

        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()) {
                } else {
                    channelFuture.channel().eventLoop().schedule(new Runnable() {
                        @Override
                        public void run() {
                            connect();
                        }
                    }, 10, TimeUnit.SECONDS);
                }
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        NettyClient client = new NettyClient();
        client.start();
        client.connect();
    }
}
