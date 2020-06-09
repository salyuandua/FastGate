package org.fastGate.core;


import java.io.File;

public class Test {

    public static void main(String[] args) {
        Class clz=Test.class;
        //System.out.println(clz.getName());
//        String clzName=clz.getName().replace('.','/')+".class";
//        System.out.println(clzName);
        System.out.println(clz.getPackage().getName());
        String rootPath=clz.getClassLoader().getResource(clz.getPackage().getName().replace('.','/')).getPath();


        File root=new File(rootPath);

        for (File f:root.listFiles()){
            System.out.println(f.getName()+","+f.isDirectory()+","+f.isFile());
        }

    }
}
