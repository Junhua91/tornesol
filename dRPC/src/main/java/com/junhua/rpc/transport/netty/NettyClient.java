package com.junhua.rpc.transport.netty;

import com.junhua.rpc.transport.codec.KryoDecoder;
import com.junhua.rpc.transport.codec.KryoEncoder;
import com.junhua.rpc.transport.model.Request;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

public class NettyClient {

    private NioEventLoopGroup workGroup = new NioEventLoopGroup();
    private Channel channel;
    private Bootstrap bootstrap;

    private final String host;
    private final int port;

    public NettyClient(String host, int port) {
        this.host = host;
        this.port = port;
    }


    public void open() throws InterruptedException {
        start();
        connect();
    }

    public Channel getChannel() throws ConnectException {
        if (channel.isActive()) {
            return channel;
        } else {
            throw new ConnectException("channel is not active");
        }
    }

    /**
     * 发送请求到服务端
     *
     * @param request
     */
    public void sendMessage(Request request) throws ConnectException {
        if (channel.isActive()) {
            channel.writeAndFlush(request);
        } else {
            throw new ConnectException("channel is not active");
        }
    }

    private void start() {

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

    private void connect() throws InterruptedException {

        if (channel != null && channel.isActive()) return;

        ChannelFuture future = bootstrap.connect(new InetSocketAddress("127.0.0.1", 9500)).sync();


        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()) {
                    channel = channelFuture.channel();
                } else {
                    channelFuture.channel().eventLoop().schedule(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                connect();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }, 10, TimeUnit.SECONDS);
                }
            }
        });
    }
}
