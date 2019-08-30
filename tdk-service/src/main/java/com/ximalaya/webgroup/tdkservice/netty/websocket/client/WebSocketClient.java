package com.ximalaya.webgroup.tdkservice.netty.websocket.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory;
import io.netty.handler.codec.http.websocketx.WebSocketClientProtocolHandler;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketClientCompressionHandler;

import java.net.InetSocketAddress;
import java.net.URI;

public class WebSocketClient {

    public void connect() throws InterruptedException {

        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap boot = new Bootstrap();

        try {
            boot.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new HttpClientCodec());
                            ch.pipeline().addLast(new HttpObjectAggregator(66666));
                            ch.pipeline().addLast(WebSocketClientCompressionHandler.INSTANCE);

                            URI uri = new URI("ws://127.0.0.1:9300/websocket");

                            WebSocketClientHandshaker handlerShaker = WebSocketClientHandshakerFactory.newHandshaker(
                                    uri, WebSocketVersion.V13,
                                    null,
                                    true,
                                    new DefaultHttpHeaders());
                            ch.pipeline().addLast(new WebSocketClientHandler(handlerShaker));
                        }
                    });
            Channel channel = boot.connect(new InetSocketAddress("127.0.0.1", 9300)).channel();
            channel.closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new WebSocketClient().connect();
    }
}
