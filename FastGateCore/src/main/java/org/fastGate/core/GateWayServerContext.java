package org.fastGate.core;

import java.util.List;

/**
 * {@link GateWayServerContext} is the running context of gateway server. It's singleton. Normally, It should contains
 * two containers inside: one for maintaining {@link Valve}, another for maintaining {@link Pipeline}.
 * These containers should thread-safe to visit.
 *
 * @author Xuejian Li
 */
public interface GateWayServerContext {

    /**
     * Return all pipelines this context has currently
     * @return All pipelines
     */
    public List<Pipeline> getPipelines();


    public Pipeline getPipeline(PipelineDefinition pipelineDefinition);
}
