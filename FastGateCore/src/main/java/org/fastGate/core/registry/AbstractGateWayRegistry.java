package org.fastGate.core.registry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class  AbstractGateWayRegistry  implements GateWayRegistry{
    protected final Map<String, Set<Instance>> servicesInstances=new HashMap<>();

}
