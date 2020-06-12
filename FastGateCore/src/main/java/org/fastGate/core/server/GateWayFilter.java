package org.fastGate.core.server;

@FunctionalInterface
public interface GateWayFilter {

    public boolean doFilter(GateWayHttpRequest request,GateWayHttpResponse response);

}
