package com.ximalaya.webgroup.tdkservice.netty.udp.multi;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class BroadCaster {

    NioEventLoopGroup group = new NioEventLoopGroup();

    public void run() throws InterruptedException {
        Bootstrap boot = new Bootstrap();
        boot.group(group).channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST, true)
                .handler(new CasterEncoder());
        Channel ch = boot.bind(0).sync().channel();

        int count = 0;
        while (true) {

            count++;
            ch.writeAndFlush(new LogMsg(null, count, LogConst.getLogInfo()));

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }

        }
    }

    public void stop() {
        group.shutdownGracefully();
    }


    public static void main(String[] args) throws InterruptedException {
        BroadCaster caster = new BroadCaster();
        try {
            caster.run();
        }finally {
            caster.stop();
        }
    }
}
