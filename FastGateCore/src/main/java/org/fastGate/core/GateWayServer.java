package org.fastGate.core;

public interface GateWayServer {


    public void start() throws GateWayServerStartException;



    public void stop() throws GateWayServerStopException;
}
