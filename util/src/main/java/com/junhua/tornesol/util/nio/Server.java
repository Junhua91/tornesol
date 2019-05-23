package com.junhua.tornesol.util.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {

    private Selector selector;
    private boolean start = true;

    public void start() {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.bind(new InetSocketAddress("127.0.0.1", 8082));

            selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);


            while (start) {

                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();

                Iterator<SelectionKey> keyIterator = keys.iterator();

                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();

                    if (!key.isValid()) {
                        continue;
                    }

                    if (key.isReadable()) {
                        SocketChannel sc = (SocketChannel) key.channel();
                        ByteBuffer bf = ByteBuffer.allocate(1024);
                        bf.clear();

                        int readNum = sc.read(bf);
                        if (readNum > 0) {
                            bf.flip();
                            byte[] bytes = new byte[bf.remaining()];
                            bf.get(bytes);
                            String inMsg = new String(bytes, "UTF-8");
                            System.out.println(inMsg);
                            sc.register(selector, SelectionKey.OP_WRITE);
                        } else if (readNum < 0) {
                            key.cancel();
                            sc.close();
                        }
                    }

                    if (key.isAcceptable()) {
                        ServerSocketChannel ssc2 = (ServerSocketChannel) key.channel();
                        SocketChannel sc = ssc2.accept();
                        sc.configureBlocking(false);
                        sc.register(selector, SelectionKey.OP_READ);
                        System.out.println("a new client is connected: " + sc.getRemoteAddress());
                    }

                    if (key.isWritable()) {
                        String outMsg = "已收到数据";
                        SocketChannel sc = (SocketChannel) key.channel();
                        //发送数据
                        ByteBuffer writeBf = ByteBuffer.allocate(1024);
                        writeBf.put(outMsg.getBytes());
                        writeBf.flip();
                        sc.write(writeBf);
                    }
                    keyIterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public void main(String[] args) {
        new Server().start();
    }
}
