package com.ximalaya.webgroup.tdkservice.m3.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.RetryForever;

public class PathChildrenCacheDemo {


    private static final String PATH = "/example/pathCache";


    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory
                .newClient("127.0.0.1:2181", new RetryForever(5000));
        client.start();
        PathChildrenCache cache = new PathChildrenCache(client, PATH, true);
        cache.start();

        PathChildrenCacheListener cacheListener = (client1, event) -> {
            System.out.println("事件类型：" + event.getType());
            if (null != event.getData()) {
                System.out.println("节点数据：" + event.getData().getPath() + " = " + new String(event.getData().getData()));
            }
        };


        cache.getListenable().addListener(cacheListener);
        client.create().creatingParentsIfNeeded().forPath("/example/pathCache/test01", "01".getBytes());
        client.create().creatingParentsIfNeeded().forPath("/example/pathCache/test01/01", "011".getBytes());
        client.create().creatingParentsIfNeeded().forPath("/example/pathCache/test01/02", "012".getBytes());
        Thread.sleep(1000);
        client.create().creatingParentsIfNeeded().forPath("/example/pathCache/test02", "02".getBytes());
        client.create().creatingParentsIfNeeded().forPath("/example/pathCache/test02/01", "021".getBytes());
        client.create().creatingParentsIfNeeded().forPath("/example/pathCache/test02/02", "022".getBytes());
        Thread.sleep(1000);
        client.setData().forPath("/example/pathCache/test01", "01_V2".getBytes());
        Thread.sleep(1000);
        for (ChildData data : cache.getCurrentData()) {
            System.out.println("getCurrentData:" + data.getPath() + " = " + new String(data.getData()));
        }

        System.out.println("OK!");

    }
}
