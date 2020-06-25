package org.fastGate.core.utils;

import org.fastGate.core.configure.Router;
import org.fastGate.core.server.GateWayFilter;
import org.fastGate.core.server.GateWayFilterDefinition;
import org.fastGate.core.server.GateWayHttpRequest;
import org.fastGate.core.server.GateWayHttpResponse;

import java.util.*;

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
        public URLTreeNode(){
            children=new HashSet<>();
            isLeaf=false;
            filters=new TreeSet<>();
        }

        public boolean isMatch(UrlPatternEntry urlPatternEntry){
            if (url.contains("/*")||urlPatternEntry.getUrl().contains("/*")) return true;
            return url.equals(urlPatternEntry.getUrl());
        }

    }



    private void constructMappingTree(){
        routers.forEach(router -> {
            String patternUrl=router.getPatternUrl();
            LinkedList<UrlPatternEntry> urlPatternEntries=URLUtils.parsePatternUrl(patternUrl);
            buildRouterInMapper(root,router,urlPatternEntries);


        });

    }

    private URLTreeNode buildRouterInMapper(URLTreeNode node,Router router,LinkedList<UrlPatternEntry> urlPatternEntries){
        if (urlPatternEntries.size()==0) return node;
        UrlPatternEntry currentUrlPattern= urlPatternEntries.removeFirst();

        if (node==null){
            node=new URLTreeNode();
            node.url=currentUrlPattern.getUrl();
            if (currentUrlPattern.isEnd()) node.isLeaf=true;

            return node;
        }





        return null;
    }



}
