package org.fastGate.core.server;

import java.util.Objects;

public class GateWayFilterDefinition {
    private Class<? extends GateWayFilter> gateWayFilterClz;
    private org.fastGate.core.annotation.GateWayFilter gateWayFilterAnnotation;
    private GateWayFilter gateWayFilter;

    public GateWayFilterDefinition(Class<? extends GateWayFilter> gateWayFilterClz, org.fastGate.core.annotation.GateWayFilter gateWayFilterAnnotation) {
        Objects.requireNonNull(gateWayFilterClz);
        Objects.requireNonNull(gateWayFilterAnnotation);
        this.gateWayFilterClz = gateWayFilterClz;
        this.gateWayFilterAnnotation = gateWayFilterAnnotation;
    }

    public GateWayFilter define(){
        if (gateWayFilter!=null) return gateWayFilter;
        try {
            gateWayFilter= gateWayFilterClz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return gateWayFilter;

    }

    public String getURLPattern(){
        return gateWayFilterAnnotation.urlPattern();
    }

    public int getFilterOrder(){
        return gateWayFilterAnnotation.order();
    }



}
