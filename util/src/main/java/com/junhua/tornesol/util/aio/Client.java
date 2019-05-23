package com.junhua.tornesol.util.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class Client {

    private AsynchronousSocketChannel aClient;

    public void start() throws IOException {

        aClient = AsynchronousSocketChannel.open();

        CompletionHandler<Void, String> connectHamdler = new CompletionHandler<Void, String>() {
            @Override
            public void completed(Void result, String attachment) {
                String msg = "message from client".trim();
                ByteBuffer bf = ByteBuffer.wrap(msg.getBytes());
                aClient.write(bf, null, new CompletionHandler<Integer, Object>() {
                    @Override
                    public void completed(Integer result, Object attachment) {
                        System.out.println("send message to server");
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        System.out.println("client fails to send message");
                    }
                });
            }

            @Override
            public void failed(Throwable exc, String attachment) {
                System.out.println("connection fails");
            }
        };

        aClient.connect(new InetSocketAddress("127.0.0.1", 8001), null, connectHamdler);

//        ByteBuffer readBf = ByteBuffer.allocate(1024);
//        aClient.read(readBf, readBf, new CompletionHandler<Integer, ByteBuffer>() {
//            @Override
//            public void completed(Integer result, ByteBuffer attachment) {
//                attachment.flip();
//                System.out.println("message received from server: " + new String(attachment.array()));
//            }
//
//            @Override
//            public void failed(Throwable exc, ByteBuffer attachment) {
//                System.out.println("fails to read message");
//            }
//        });
    }

    public static void main(String[] args) {
        try {
            new Client().start();
            Thread.sleep(1000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
