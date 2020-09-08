package org.fastGate.core.registry;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import org.fastGate.core.configure.PropertyConfigure;
import org.fastGate.core.utils.RestTemplateUtils;
import org.springframework.web.client.RestTemplate;

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

        }catch (UnknownHostException e){
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

    public static void main(String[] args) throws NacosException, UnknownHostException {
        String serverAddress="http://localhost:8848";
        NamingService namingService= NamingFactory.createNamingService(serverAddress);
        namingService.registerInstance("acctService",InetAddress.getLocalHost().getHostAddress(),8080);

    }
}
