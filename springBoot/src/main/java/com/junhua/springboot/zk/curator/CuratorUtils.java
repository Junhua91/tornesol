package com.junhua.springboot.zk.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;

public class CuratorUtils {

    /**
     * 创建zk客户端
     *
     * @return
     */
    static public CuratorFramework buildClient() {
        CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder()
                .connectString("127.0.0.1:2181")
                .retryPolicy(new RetryNTimes(1, 1000))
                .connectionTimeoutMs(5000);
        CuratorFramework client = builder.build();
        client.getConnectionStateListenable().addListener((cli, state) -> {
            if (state == ConnectionState.CONNECTED) {
                System.out.println("Connected");
            } else if (state == ConnectionState.LOST) {
                System.out.println("Lost");
            } else if (state == ConnectionState.RECONNECTED) {
                System.out.println("ReConnected");
            }
        });
        client.start();
        return client;
    }


    /**
     * 递归创建节点
     *
     * @param client
     * @param path
     * @param isEphemeral
     */
    static public void create(CuratorFramework client, String path, boolean isEphemeral) {

        if (!isEphemeral) {
            if (checkExists(client, path)) {
                return;
            }
        }
        int i = path.lastIndexOf('/');
        if (i > 0) {
            create(client, path.substring(0, i), false);
        }
        if (isEphemeral) {
            createNode(client, true, path);
        } else {
            createNode(client, false, path);
        }

    }


    static public boolean checkExists(CuratorFramework client, String path) {
        try {
            if (client.checkExists().forPath(path) != null) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }


    /**
     * 创建临时、永久节点
     *
     * @param client
     * @param isEphemeral
     * @param path
     */
    static private void createNode(CuratorFramework client, boolean isEphemeral, String path) {
        try {

            if (isEphemeral) {
                client.create().withMode(CreateMode.EPHEMERAL).forPath(path);
            } else {
                client.create().forPath(path);
            }
        } catch (KeeperException.NodeExistsException e) {
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }
}
