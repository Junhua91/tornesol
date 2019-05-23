package com.junhua.tornesol.util.nio;

import org.apache.commons.codec.language.Nysiis;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Client {

    private Selector selector;

    public void start() {

        SocketChannel sc = null;
        try {
            sc = SocketChannel.open();
            sc.configureBlocking(false);

            selector = Selector.open();
            sc.register(selector, SelectionKey.OP_CONNECT);

            sc.connect(new InetSocketAddress("127.0.0.1", 8082));

            while (true) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();

                while (selectionKeyIterator.hasNext()) {
                    SelectionKey key = selectionKeyIterator.next();
                    SocketChannel sc2 = (SocketChannel) key.channel();
                    if (key.isValid()) {

                        if (key.isConnectable()) {
                            if (sc.finishConnect()) {
                            }
                        }
                        if (key.isReadable()) {
                            ByteBuffer bf = ByteBuffer.allocate(1024);
                            int num = sc2.read(bf);

                            if (num > 0) {
                                bf.flip();
                                byte[] bytes = new byte[bf.remaining()];
                                bf.get(bytes);
                                String result = new String(bytes, "UTF-8");
                                System.out.println(result);
                            } else if (num < 0) {
                                key.cancel();
                                sc2.close();
                            }
                        }
                    }
                    selectionKeyIterator.remove();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMsg(SocketChannel sc, String msg) throws IOException {
        sc.register(selector, SelectionKey.OP_READ);
        ByteBuffer bf = ByteBuffer.allocate(1024);
        bf.put(msg.getBytes());
        bf.flip();
        sc.write(bf);
    }

    static public void main(String[] args) {
        Client client = new Client();
        client.start();
    }
}
