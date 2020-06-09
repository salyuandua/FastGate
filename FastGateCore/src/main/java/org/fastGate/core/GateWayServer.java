package org.fastGate.core;

public interface GateWayServer {

    public static final int TERMINATED=-1;

    public static final int STARTING=0;

    public static final int RUNNING=1;

    public static final int STOPPING=2;





    public void start() throws GateWayServerStartException;



    public void stop() throws GateWayServerStopException;
}
