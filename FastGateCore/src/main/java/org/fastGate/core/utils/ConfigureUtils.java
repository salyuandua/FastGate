package org.fastGate.core.utils;

import org.fastGate.core.configure.PropertyConfigure;

public class ConfigureUtils {
    private static PropertyConfigure propertyConfigure;
    public static PropertyConfigure getPropertyConfigure(){
        return propertyConfigure;
    }
    public static synchronized void setPropertyConfigure(PropertyConfigure newPropertyConfigure){
        if (propertyConfigure==null) {
            propertyConfigure=newPropertyConfigure;
            return;
        }
        propertyConfigure.merge(newPropertyConfigure);
    }
}
