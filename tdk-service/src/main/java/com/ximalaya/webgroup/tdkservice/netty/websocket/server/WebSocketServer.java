package com.ximalaya.webgroup.tdkservice.netty.websocket.server;

import com.ximalaya.webgroup.tdkservice.netty.protocol.server.NettyServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;
import io.netty.util.concurrent.ImmediateEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebSocketServer {

    private static final Logger LOG = LoggerFactory.getLogger(NettyServer.class);

    //保存所有连接
    private final static ChannelGroup channelGroup =
            new DefaultChannelGroup(ImmediateEventExecutor.INSTANCE);

    public void bind() throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        ServerBootstrap boot = new ServerBootstrap();

        try {
            boot.group(group)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new HttpServerCodec());
                            ch.pipeline().addLast(new HttpObjectAggregator(66666));
                            ch.pipeline().addLast(new WebSocketServerCompressionHandler());
                            ch.pipeline().addLast(new WebSocketServerProtocolHandler("/websocket",
                                    null, true));
                            ch.pipeline().addLast(new WebSocketServerHttpHandler());
                        }
                    });

            Channel channel = boot.bind(9300).sync().channel();
            channel.closeFuture().sync();
            LOG.info("Netty server starts at: 127.0.0.1:9300");
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new WebSocketServer().bind();
    }
}
