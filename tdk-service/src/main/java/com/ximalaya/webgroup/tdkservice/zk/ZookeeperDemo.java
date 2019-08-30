package com.ximalaya.webgroup.tdkservice.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ZookeeperDemo {


    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if (event.getState() == Event.KeeperState.SyncConnected) {
                    latch.countDown();
                }
            }
        });
        latch.await();

        try {
            List<String> children = zk.getChildren("/", null);
            children.stream().forEach(p -> System.out.println(p));
        } catch (KeeperException e) {
            e.printStackTrace();
        }
        System.out.println(zk);
    }
}
