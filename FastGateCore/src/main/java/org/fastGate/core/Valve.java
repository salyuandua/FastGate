package org.fastGate.core;


/**
 * {@link Valve} represents basic execution unit in gateway server.
 *
 * @author Xuejian Li
 */
public interface Valve {

    /**
     *
     * @return true: pipeline should execute next Valve if available
     *          false: pipeline should end the entire chain
     */
    public boolean execute();

}
