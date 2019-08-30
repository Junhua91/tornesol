package com.ximalaya.webgroup.tdkservice.zk;

import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;


@Component
public class ServiceRegistryImpl implements ServiceRegistry, Watcher {

    private static CountDownLatch latch = new CountDownLatch(1);
    private ZooKeeper zk;
    private static final String REGISTRY_PATH = "/registry";
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    public ServiceRegistryImpl() {
    }

    public ServiceRegistryImpl(String zkServer) {

        try {
            zk = new ZooKeeper(zkServer, 5000, this);
            latch.await();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void register(String serviceName, String serviceAddress) {

        try {
            if (zk.exists(REGISTRY_PATH, true) == null) {
                zk.create(REGISTRY_PATH, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            String servicePath = REGISTRY_PATH + "/" + serviceName;
            if (zk.exists(servicePath, true) == null) {
                zk.create(servicePath, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            String addressPath = servicePath + "/address-";
            String addressNode = zk.create(addressPath, serviceAddress.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            logger.info("create node: {} => {}", addressNode, serviceAddress);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent event) {
        if (event.getState() == Event.KeeperState.SyncConnected) {
            if(event.getType() == Event.EventType.NodeCreated){
                logger.info("***** node created ****");
            }else if(event.getType() == Event.EventType.NodeDataChanged){
                logger.info("***** node changed ****");
            }
            latch.countDown();
        }
    }
}
