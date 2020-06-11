package org.fastGate.core.configure;

public class ConfigureClassLoader extends ClassLoader{


    private static final String GATE_WAY_PAKEAGE_PREFIX="org.fastGate";

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
}
