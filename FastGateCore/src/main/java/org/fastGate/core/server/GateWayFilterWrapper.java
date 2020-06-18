package org.fastGate.core.server;

public class GateWayFilterWrapper {
    private GateWayFilter gateWayFilter;
    private org.fastGate.core.annotation.GateWayFilter gateWayFilterAnnotation;

    public GateWayFilterWrapper(GateWayFilter gateWayFilter, org.fastGate.core.annotation.GateWayFilter gateWayFilterAnnotation) {
        this.gateWayFilter = gateWayFilter;
        this.gateWayFilterAnnotation = gateWayFilterAnnotation;
    }



}
