package org.fastGate.core.configure;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;


public final class PropertyConfigure {
    public static final String APPLICATION_ID="application.id";
    public static final String APPLICATION_PORT="application.port";

    public static final String REGISTRY_TYPE="registry.type";
    public static final String REGISTRY_URL="registry.url";
    public static final String REGISTRY_CLUSTER="registry.cluster";


    private Map<String,String> propertyMap=new HashMap<>();

    public String getProperty(String key){
        key=key.trim();
        if (StringUtils.isBlank(key)) throw new IllegalArgumentException("Key should not be blank");
        return propertyMap.get(key);
    }


    public PropertyConfigure putProperty(String key,String value){
        key=key.trim();value=value.trim();
        if (StringUtils.isBlank(key)||StringUtils.isBlank(value)) throw new IllegalArgumentException("Key or value shouldn't be blank");
        propertyMap.put(key, value);
        return this;
    }

    public Map<String, String> getPropertyMap() {
        return propertyMap;
    }


    public void merge(PropertyConfigure propertyConfigure){
        Map<String,String> anotherMap=propertyConfigure.getPropertyMap();
        anotherMap.forEach((k,v)->{
            this.putProperty(k,v);
        });
    }

}
