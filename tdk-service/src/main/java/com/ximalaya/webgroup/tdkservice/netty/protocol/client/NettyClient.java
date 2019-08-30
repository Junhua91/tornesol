package com.ximalaya.webgroup.tdkservice.netty.protocol.client;

import com.ximalaya.webgroup.tdkservice.netty.protocol.model.BusinessTypeEnum;
import com.ximalaya.webgroup.tdkservice.netty.protocol.model.MessageProto;
import com.ximalaya.webgroup.tdkservice.netty.protocol.server.NettyServer;
import com.ximalaya.webgroup.tdkservice.netty.protocol.utils.MessageUtils;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class NettyClient {

    private static final Logger LOG = LoggerFactory.getLogger(NettyServer.class);

    private NioEventLoopGroup workGroup = new NioEventLoopGroup();
    private Channel channel;
    private Bootstrap bootstrap;

    public void start() {
        bootstrap = new Bootstrap();
        bootstrap.group(workGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new IdleStateHandler(0, 0, 5));
                        ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
                        ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
                        ch.pipeline().addLast(new ProtobufDecoder(MessageProto.messageProto.getDefaultInstance()));
                        ch.pipeline().addLast(new ProtobufEncoder());
                        ch.pipeline().addLast(new NettyClientHandler());
                    }
                });
    }


    public void connect() {

        if (channel != null && channel.isActive()) return;

        ChannelFuture future = bootstrap.connect(new InetSocketAddress("127.0.0.1", 9200));

        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()) {
                    channel = channelFuture.channel();
                    LOG.info("Connect to server successfully!");
                    for (int i = 0; i < 100; i++) {
                        sendMsg(channel);
                    }
                } else {
                    LOG.error("Failed to connect to server, try connect after 10s");
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

    private void sendMsg(Channel channel) {
        if (channel == null || !channel.isActive()) {
            throw new IllegalStateException("和服务器未建立起有效连接！");
        }
        Map<String, String> attachment = new HashMap<String, String>() {
            {
                put("testKey2", "testValue2");
            }
        };
        MessageProto.messageProto message = MessageUtils.createMessage(1, 1234567L,
                BusinessTypeEnum.SERVICE_REQ, 22222, attachment, "这是一条服务请求消息");

        channel.writeAndFlush(message);
    }

    public static void main(String[] args) throws InterruptedException {
        NettyClient client = new NettyClient();
        client.start();
        client.connect();
    }
}
