package org.fastGate.core.server;

@FunctionalInterface
public interface GateWayFilter {

    public static final int MIN_ORDER=0;

    public static final int MAX_ORDER=Integer.MAX_VALUE;

    public boolean doFilter(GateWayHttpRequest request,GateWayHttpResponse response);

}
