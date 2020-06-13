package org.fastGate.core.server;

import org.fastGate.core.Pipeline;
import org.fastGate.core.Valve;

import java.util.List;
import java.util.Objects;

public class DefaultGateWayPipeline implements Pipeline {

    private Valve basicValve;

    public DefaultGateWayPipeline(Valve basicValve){
        Objects.requireNonNull(basicValve);
        this.basicValve=basicValve;
    }


    @Override
    public Valve getBasicValve() {
        return basicValve;
    }

    @Override
    public Valve setBasicValve(Valve basicValve) {
        return null;
    }

    @Override
    public List<Valve> getValves() {
        return null;
    }

    @Override
    public void appendValve(Valve valve) {

    }

    @Override
    public void addHeadValve(Valve valve) {

    }
}
