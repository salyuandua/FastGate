package org.fastGate.core.loadbalance;

import org.fastGate.core.server.GateWayHttpRequest;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomStrategy implements LoadBalanceStrategy{
    private Random random=new Random();
    @Override
    public String pick(GateWayHttpRequest request, Set<String> ips) {
        int randomInt=random.nextInt(ips.size());
        String[] ipArray=new String[ips.size()];
        ipArray=ips.toArray(ipArray);
        return ipArray[randomInt];
    }


    public static void main(String[] args) {
        LoadBalanceStrategy randomSt=new RandomStrategy();
        Set<String> set=new HashSet<>();
        set.add("192.0.0.1");
        set.add("192.0.0.2");
        set.add("192.0.0.3");
        set.add("192.0.0.4");
        set.add("192.0.0.5");
        set.add("192.0.0.6");
        set.add("192.0.0.7");
        set.add("192.0.0.8");
        for (int i=0;i<100;i++){
            randomSt.pick(null,set);
        }
    }
}
