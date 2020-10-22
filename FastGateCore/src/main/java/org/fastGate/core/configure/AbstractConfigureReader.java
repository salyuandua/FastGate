package org.fastGate.core.configure;

import java.io.InputStream;

public abstract class AbstractConfigureReader implements  ConfigureReader{
    public AbstractConfigureReader(InputStream in){

    }
    @Override
    public PropertyConfigure read() {
        return null;
    }
}
