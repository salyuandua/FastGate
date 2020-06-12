package org.fastGate.core.server;

public interface GateWayHttpRequest {


    public HttpMethod getMethod();


    public String getHeader(String headKey);

    public byte[] getBody();
}
