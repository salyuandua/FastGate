package org.fastGate.core.server;

import org.fastGate.core.GateWayServer;
import org.fastGate.core.GateWayServerContext;
import org.fastGate.core.GateWayServerStartException;
import org.fastGate.core.GateWayServerStopException;

import java.util.concurrent.atomic.AtomicInteger;


public abstract class AbstractGateWayServer implements GateWayServer {

    //private AtomicInteger serverState=new AtomicInteger(GateWayServer.TERMINATED);
    private int serverState=GateWayServer.TERMINATED;

    private GateWayServerContext serverContext;



    protected abstract GateWayServerContext createServerContext();

    @Override
    public void start() throws GateWayServerStartException {
        synchronized (this){
            if (serverState!=GateWayServer.TERMINATED) throw new GateWayServerStartException();


            serverContext=createServerContext();

        }
    }

    @Override
    public void stop() throws GateWayServerStopException {

    }

    public int getServerState(){
        return new Integer(serverState);
    }
}
