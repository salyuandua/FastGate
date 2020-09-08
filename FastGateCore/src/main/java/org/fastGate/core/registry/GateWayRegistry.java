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
     * Register current gateway service to registry
     * Should be executed while the gateway server bootstrapping.
     *
     * @throws GateWayRegisterException
     */
    public void register() throws GateWayRegisterException;

    /**
     * Pull other services' info from registry
     * @throws GateWayRegisterException
     */

    public void pull() throws GateWayRegisterException;

    public PropertyConfigure getConfigure();
}
