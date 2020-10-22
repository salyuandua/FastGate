package org.fastGate.core.registry;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import org.fastGate.core.configure.PropertyConfigure;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GateWayNacosRegistry extends AbstractGateWayRegistry{
    //private static final String nacos


    private PropertyConfigure propertyConfigure;
    private NamingService namingService;
    private boolean isRegistered=false;
    public GateWayNacosRegistry(PropertyConfigure propertyConfigure
                                ) throws GateWayRegisterException {
        Objects.requireNonNull(propertyConfigure);
        this.propertyConfigure=propertyConfigure;
        try {
            namingService=NamingFactory.createNamingService(propertyConfigure.getProperty(PropertyConfigure.REGISTRY_URL));
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

    private com.alibaba.nacos.api.naming.pojo.Instance buildNacosInstance(Instance gatewayInstance,String serviceName){
        com.alibaba.nacos.api.naming.pojo.Instance nacosInstance=new com.alibaba.nacos.api.naming.pojo.Instance();
        nacosInstance.setServiceName(serviceName);
        nacosInstance.setHealthy(true);
        nacosInstance.setIp(gatewayInstance.getIp());
        nacosInstance.setPort(gatewayInstance.getPort());
        gatewayInstance.getMetaData().forEach((k,v)->{
            nacosInstance.addMetadata(k,v);
        });

        return nacosInstance;
    }




    @Override
    public synchronized void register() throws GateWayRegisterException {
        if (isRegistered) return;

        try {
            String serviceName=propertyConfigure.getProperty(PropertyConfigure.APPLICATION_ID);
            String ip=InetAddress.getLocalHost().getHostAddress();
            String port=propertyConfigure.getProperty(PropertyConfigure.APPLICATION_PORT);
            //create instance
            Instance instance=new Instance.Builder(ip,Integer.parseInt(port)).build();
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
            String nowTimeStamp=dateFormat.format(new Date());
            instance.getMetaData().put(Instance.REGISTER_TIME,nowTimeStamp);
            com.alibaba.nacos.api.naming.pojo.Instance nacosInstance=buildNacosInstance(instance,serviceName);
            namingService.registerInstance(serviceName,nacosInstance);
        }catch (UnknownHostException | NacosException e){
            throw new GateWayRegisterException();
        }

    }

    @Override
    public synchronized void pull() throws GateWayRegisterException {
        //namingService.
        //namingService.getAllInstances()

    }

    @Override
    public PropertyConfigure getConfigure() {
        return propertyConfigure;
    }

    public static void main(String[] args) throws NacosException, UnknownHostException {
        String serverAddress="http://localhost:8848";
        NamingService namingService= NamingFactory.createNamingService(serverAddress);
        namingService.registerInstance("acctService",InetAddress.getLocalHost().getHostAddress(),8080);

    }
}
