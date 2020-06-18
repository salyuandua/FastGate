package org.fastGate.core.utils;

import org.fastGate.core.configure.Router;
import org.fastGate.core.server.GateWayFilter;
import org.fastGate.core.server.GateWayFilterDefinition;
import org.fastGate.core.server.GateWayHttpRequest;
import org.fastGate.core.server.GateWayHttpResponse;

import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

public class GateWayURLTreeMapper implements GateWayURLMapper{

    private URLTreeNode root;

    private Set<GateWayFilterDefinition> gateWayFilterDefinitions;

    private Set<Router> routers;

    public GateWayURLTreeMapper(Set<GateWayFilterDefinition> gateWayFilterDefinitions,Set<Router> routers){
        Objects.requireNonNull(gateWayFilterDefinitions);
        Objects.requireNonNull(routers);
        this.gateWayFilterDefinitions=gateWayFilterDefinitions;
        this.routers=routers;
        initMapper();
    }



    private void initMapper(){
        root=new URLTreeNode();
        root.url="/";


    }



    @Override
    public GateWayHttpResponse map(GateWayHttpRequest request) {


        return null;
    }


    static class URLTreeNode{
        private URLTreeNode parent;
        private Set<URLTreeNode> children;
        private boolean isLeaf;
        private String url;
        private SortedSet<GateWayFilter> filters;


    }



    private void constructMappingTree(){
        routers.forEach(router -> {



        });

    }

    private URLTreeNode searchAndPutRouter(URLTreeNode node,Router router,String currentUrl){
        if (node==null){

        }

        return null;
    }




}
