package org.fastGate.core.registry;


/**
 * Basic detailed server info which registered in registries.
 * @author Xuejian Li
 */
public class ServerInfo {

    private String ip;
    private String port;
    private String serviceName;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
