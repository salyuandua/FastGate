package org.fastGate.core.server;

import org.fastGate.core.GateWayServer;
import org.fastGate.core.GateWayServerContext;
import org.fastGate.core.GateWayServerStartException;
import org.fastGate.core.GateWayServerStopException;
import org.fastGate.core.annotation.GateWayConfigure;
import org.fastGate.core.configure.Router;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public abstract class AbstractGateWayServer implements GateWayServer {

    private static final String CLASS_SUFFIX=".class";

    private static final String YAML_SUFFIX=".yaml";

    private static final String YAML_PREFIX="fastGate";


    //private AtomicInteger serverState=new AtomicInteger(GateWayServer.TERMINATED);
    private int serverState=GateWayServer.TERMINATED;

    private GateWayServerContext serverContext;

    private String yamlLocation;

    private Class bootStrapClz;

    public AbstractGateWayServer(String yamlLocation,Class bootStrapClz){
        this.yamlLocation=yamlLocation;
        this.bootStrapClz=bootStrapClz;
    }




    private void loadConfigureFromClassPath(){
        String rootPackage=bootStrapClz.getPackage().getName();
        bootStrapClz.getClassLoader();



    }

    private void doLoadConfigureClass(Class gateWayConfigureClz,GateWayConfigure gateWayConfigure){
        try {
            //check if no non-parameter constructor
            Constructor[] constructors =gateWayConfigureClz.getDeclaredConstructors();
            Object gateWayConfigureObj=null;
            for (Constructor constructor:constructors){
                if(constructor.getParameterCount()==0) gateWayConfigureObj=constructor.newInstance();
            }
            if (gateWayConfigureObj==null) throw new GateWayServerStartException("No default constructor");

            Method[] methods=gateWayConfigureClz.getDeclaredMethods();

            for (Method method:methods){
                if (method.getReturnType().equals(Router.class)){//user configure router
                   if (method.getParameterCount()>0) throw new GateWayServerStartException("Should not have any parameter");
                   Router router=(Router) method.invoke(gateWayConfigureObj);


                }

            }


            //Object gateWayConfigureObj= gateWayConfigureClz.newInstance();



        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (GateWayServerStartException e) {
            e.printStackTrace();
        }

    }



    private void loadConfigureClass(File classFile,String classPath){
        if (classFile.isFile()){
            if (classPath.endsWith(CLASS_SUFFIX)){
                try {
                    Class candidateClz= bootStrapClz.getClassLoader().loadClass(classPath.substring(0,classPath.lastIndexOf('.')));
                    Object gateWayConfigureAnnotationObj=  candidateClz.getAnnotation(GateWayConfigure.class);
                    if (gateWayConfigureAnnotationObj!=null) {
                        GateWayConfigure gateWayConfigure=(GateWayConfigure) gateWayConfigureAnnotationObj;



                    }

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }



        }

        if (classFile.isDirectory()){
            for (File f:classFile.listFiles()){
                loadConfigureClass(f,classPath+"."+f.getName());
            }

        }


    }



    protected abstract GateWayServerContext createServerContext();

    protected abstract void startInternalServer();

    @Override
    public void start() throws GateWayServerStartException {
        synchronized (this){
            if (serverState!=GateWayServer.TERMINATED) throw new GateWayServerStartException("");
            serverState=GateWayServer.STARTING;

            serverContext=createServerContext();

            loadConfigureFromClassPath();


            startInternalServer();


        }
    }

    @Override
    public void stop() throws GateWayServerStopException {

    }

    public int getServerState(){
        return serverState;
    }


    public String getYamlLocation() {
        return yamlLocation;
    }
}
