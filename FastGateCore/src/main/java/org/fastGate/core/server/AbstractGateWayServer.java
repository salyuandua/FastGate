package org.fastGate.core.server;

import org.fastGate.core.GateWayServer;
import org.fastGate.core.GateWayServerContext;
import org.fastGate.core.GateWayServerStartException;
import org.fastGate.core.GateWayServerStopException;

import java.util.concurrent.atomic.AtomicInteger;


public abstract class AbstractGateWayServer implements GateWayServer {

    private static final String CLASS_SUFFIX=".class";

    private static final String YAML_SUFFIX=".yaml";

    private static final String YAML_PREFIX="fastGate";


    //private AtomicInteger serverState=new AtomicInteger(GateWayServer.TERMINATED);
    private int serverState=GateWayServer.TERMINATED;

    private GateWayServerContext serverContext;

    private String yamlLocation;

    private Class bootStrapClz;

    public AbstractGateWayServer(String yamlLocation,Class bootStrapClz){
        this.yamlLocation=yamlLocation;
        this.bootStrapClz=bootStrapClz;
    }




    private void loadConfigureFromClassPath(){




    }



    protected abstract GateWayServerContext createServerContext();

    @Override
    public void start() throws GateWayServerStartException {
        synchronized (this){
            if (serverState!=GateWayServer.TERMINATED) throw new GateWayServerStartException();
            serverState=GateWayServer.STARTING;

            serverContext=createServerContext();

            loadConfigureFromClassPath();



        }
    }

    @Override
    public void stop() throws GateWayServerStopException {

    }

    public int getServerState(){
        return new Integer(serverState);
    }


    public String getYamlLocation() {
        return yamlLocation;
    }
}
