package org.fastGate.core.loadbalance;


import org.fastGate.core.server.GateWayHttpRequest;

import java.util.Set;

/**
 * {@link LoadBalanceStrategy} represents an abstract modal for different load balance algorithms.
 *
 *
 *
 * @author Xuejian Li
 */
public interface LoadBalanceStrategy {

    public void pick(GateWayHttpRequest request, Set<String> ips);

}
