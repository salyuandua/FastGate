package org.fastGate.core.server;

import org.fastGate.core.GateWayServerContext;
import org.fastGate.core.Pipeline;
import org.fastGate.core.PipelineDefinition;
import org.fastGate.core.Valve;

import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractGateWayServerContext implements GateWayServerContext {

    private final ConcurrentHashMap<String, Valve> valves=new ConcurrentHashMap<>();

    private final ConcurrentHashMap<PipelineDefinition, Pipeline> pipelines=new ConcurrentHashMap<>();



}
