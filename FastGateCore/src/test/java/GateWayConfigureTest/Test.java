package GateWayConfigureTest;


import org.fastGate.core.annotation.GateWayConfigure;

import java.io.File;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException {
        Class clz=Test.class;
        //System.out.println(clz.getName());
//        String clzName=clz.getName().replace('.','/')+".class";
//        System.out.println(clzName);
        System.out.println(clz.getPackage().getName());
        String rootPath=clz.getClassLoader().getResource(clz.getPackage().getName().replace('.','/')).getPath();


        File root=new File(rootPath);

//        for (File f:root.listFiles()){
//
//            System.out.println(f.getName()+","+f.isDirectory()+","+f.isFile());
//
//        }
        dfsFile(root,clz.getPackage().getName(),clz);

    }

    public static void dfsFile(File file,String clzPath,Class clz) throws ClassNotFoundException {
        if (file.isFile()){
            System.out.println(clzPath);
             Class fileClz= clz.getClassLoader().loadClass(clzPath.substring(0,clzPath.lastIndexOf('.')) );
            Object o=fileClz.getAnnotation(GateWayConfigure.class);
            
            return;
        }
        if (file.isDirectory()){
            for (File f:file.listFiles()){
                dfsFile(f,clzPath+"."+f.getName(),clz);
            }

        }
    }



}
