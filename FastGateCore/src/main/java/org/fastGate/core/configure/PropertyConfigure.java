package org.fastGate.core.configure;

import org.apache.commons.lang3.StringUtils;

import java.util.*;


public final class PropertyConfigure {
    public static final String APPLICATION_ID="application.id";
    public static final String APPLICATION_PORT="application.port";

    public static final String REGISTRY_TYPE="registry.type";
    public static final String REGISTRY_URL="registry.url";
    //public static final String REGISTRY_CLUSTER="registry.cluster";


    private Map<String,String> propertyMap=new HashMap<>();

    public static Set<String> getRequiredConfigKeys(){
        Set<String> requiredConfigKey=new HashSet<>();
        requiredConfigKey.addAll(Arrays.asList(APPLICATION_ID,APPLICATION_PORT,REGISTRY_TYPE,REGISTRY_URL));
        return requiredConfigKey;
    }

    public String getProperty(String key){
        key=key.trim();
        if (StringUtils.isBlank(key)) throw new IllegalArgumentException("Key should not be blank");
        return propertyMap.get(key);
    }


    public PropertyConfigure putProperty(String key,String value){

        if (StringUtils.isBlank(key)||StringUtils.isBlank(value)) throw new IllegalArgumentException("Key or value shouldn't be blank");
        key=key.trim();
        value=value.trim();
        
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
