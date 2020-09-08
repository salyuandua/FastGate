package org.fastGate.core.registry;

import java.util.Map;
import java.util.Objects;

public class Instance {
    public static final String REGISTER_TIME="registerTime";
    private String ip;
    private int port;
    private Map<String,String> metaData;

    public static class Builder{
        private String ip;
        private int port;
        public Builder(String ip,int port){
            Objects.requireNonNull(ip);
            this.ip=ip;
            this.port=port;
        }
        public Instance build(){
            return new Instance(this);
        }
    }

    private Instance(Builder builder){
        this.ip=builder.ip;
        this.port=builder.port;
    }



    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Map<String, String> getMetaData() {
        return metaData;
    }

    public void setMetaData(Map<String, String> metaData) {
        this.metaData = metaData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instance instance = (Instance) o;
        return port == instance.port &&
                Objects.equals(ip, instance.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port);
    }
}
