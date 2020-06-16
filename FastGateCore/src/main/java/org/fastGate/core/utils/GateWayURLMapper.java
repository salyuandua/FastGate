package org.fastGate.core.utils;

import org.fastGate.core.server.GateWayHttpRequest;
import org.fastGate.core.server.GateWayHttpResponse;


/**
 * {@link GateWayURLMapper} represents an abstract url mapper in fastGate. There may be multiple implementations
 * and a default tree-based implementation {@link GateWayURLTreeMapper}
 *
 * @author Xuejian Li
 */
public interface GateWayURLMapper {

    public GateWayHttpResponse map(GateWayHttpRequest request);


}
