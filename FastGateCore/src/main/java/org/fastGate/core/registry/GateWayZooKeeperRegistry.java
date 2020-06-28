package org.fastGate.core.registry;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.fastGate.core.configure.PropertyConfigure;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GateWayZooKeeperRegistry implements GateWayRegistry{

    private PropertyConfigure registryConfigure;

    public GateWayZooKeeperRegistry(PropertyConfigure registryConfigure){
        String hostUrl=registryConfigure.getProperty(PropertyConfigure.ZOOKEEPER_HOST_URLS);


    }



    @Override
    public void register(PropertyConfigure registryConfigure) throws GateWayRegisterException {

    }

    @Override
    public void pull() throws GateWayRegisterException {

    }


    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zk=new ZooKeeper("localhost", 10000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getType());
            }
        });
        zk.getData("/services",true,null);

        Thread.sleep(Long.MAX_VALUE);
    }
}
