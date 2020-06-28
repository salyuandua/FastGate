package org.fastGate.core.registry;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import org.fastGate.core.configure.PropertyConfigure;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GateWayNacosRegistry implements GateWayRegistry{
    private PropertyConfigure propertyConfigure;
    private NamingService namingService;
    public GateWayNacosRegistry(PropertyConfigure propertyConfigure) throws GateWayRegisterException {
        this.propertyConfigure=propertyConfigure;
        try {
            namingService= NamingFactory.createNamingService(propertyConfigure.getProperty(PropertyConfigure.REGISTRY_URL));
        }catch (NacosException e){
            throw new GateWayRegisterException();
        }
    }

    @Override
    public void register() throws GateWayRegisterException {
        if (namingService==null) throw new GateWayRegisterException();
        try {
            String serviceName=propertyConfigure.getProperty(PropertyConfigure.APPLICATION_ID);
            String ip=InetAddress.getLocalHost().getHostAddress();
            String port=propertyConfigure.getProperty(PropertyConfigure.APPLICATION_PORT);
            String cluster=propertyConfigure.getProperty(PropertyConfigure.REGISTRY_CLUSTER);
            namingService.registerInstance(serviceName,ip,Integer.parseInt(port),cluster);
        }catch (UnknownHostException | NacosException e){
            throw new GateWayRegisterException();
        }

    }

    @Override
    public void pull() throws GateWayRegisterException {
        //namingService.
    }

    @Override
    public PropertyConfigure getConfigure() {
        return propertyConfigure;
    }
}
