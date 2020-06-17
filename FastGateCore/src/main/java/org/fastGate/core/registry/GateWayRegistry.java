package org.fastGate.core.registry;

import org.fastGate.core.configure.PropertyConfigure;

/**
 * {@link GateWayRegistry} is an abstract modal for registering and pulling server info from a special
 *  registry(like Apache Zookeeper, Netflix Eureka ...) in distribution environment.
 *
 * @author Xuejian Li
 *
 * @see GateWayZooKeeperRegistry
 */
public interface GateWayRegistry {

    /**
     * Should be executed while the gateway server bootstrapping.
     * @param registryConfigure
     * @throws GateWayRegisterException
     */
    public void register(PropertyConfigure registryConfigure) throws GateWayRegisterException;

    public void pull() throws GateWayRegisterException;


}
