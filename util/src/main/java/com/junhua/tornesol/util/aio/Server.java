package com.junhua.tornesol.util.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

public class Server {

    private AsynchronousServerSocketChannel aServer;

    public Server() {
        try {
            aServer = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress("127.0.0.1", 8001));
            System.out.println("服务端启动....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
//        while (true) {
        aServer.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            ByteBuffer bf = ByteBuffer.allocate(1024);
            ByteBuffer sendBf = ByteBuffer.allocate(1024);

            @Override
            public void completed(AsynchronousSocketChannel result, Object attachment) {
                try {
                    result.read(bf).get();
                    System.out.println("服务端收到客户端请求....");
                    String msg = "服务端收到：" + new String(bf.array(), "UTF-8");
                    System.out.println(msg);
                    bf.flip();
                    //sendBf.put(msg.getBytes());
                    //result.write(sendBf);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("connection fails");
            }
        });
//        }
    }

    public static void main(String[] args) {

        new Server().start();

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
