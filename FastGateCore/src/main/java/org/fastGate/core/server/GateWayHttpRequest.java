package org.fastGate.core.server;

public interface GateWayHttpRequest {

    public String getPath();

    public HttpMethod getMethod();


    public String getHeader(String headKey);

    public byte[] getBody();
}
