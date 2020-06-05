package org.fastGate.core;

import java.util.List;

/**
 * {@link Pipeline} represents an execution chain in gateway server.
 * Each {@link Pipeline} must contains at least one {@link Valve}, which is basic valve.
 * Empty pipeline may not be allowed in {@link GateWayServerContext}.
 *
 * @author Xuejian Li
 */
public interface Pipeline {


    public Valve getBasicValve();

    public Valve setBasicValve(Valve basicValve);

    public List<Valve> getValves();

    public void appendValve(Valve valve);

    public void addHeadValve(Valve valve);
}
