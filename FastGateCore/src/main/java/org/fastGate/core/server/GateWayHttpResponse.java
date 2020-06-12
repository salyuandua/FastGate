package org.fastGate.core.server;

public interface GateWayHttpResponse {

    public void status(int statusCode);

    public void body(byte[] body);

    
}
