package com.junhua.springboot.zk.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.zookeeper.WatchedEvent;

import java.util.List;

public class CuratorDemo {

    public static void main(String[] args) throws Exception {

        String path = "/test1";

        CuratorFramework client = CuratorUtils.buildClient();
        CuratorUtils.create(client, path, true);

        client.getChildren().usingWatcher(new CuratorWatcher() {
            @Override
            public void process(WatchedEvent event) throws Exception {
                System.out.println(event.getType());
            }
        }).forPath(path);

        System.in.read();
    }


}
