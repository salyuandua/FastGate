package org.fastGate.core.configure;

import org.fastGate.core.GateWayServerStartException;

public interface ConfigureReader {

    public PropertyConfigure read() throws GateWayServerStartException;

}
