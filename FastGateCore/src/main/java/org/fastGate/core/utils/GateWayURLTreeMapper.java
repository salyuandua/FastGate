package org.fastGate.core.utils;

import org.fastGate.core.server.GateWayHttpRequest;
import org.fastGate.core.server.GateWayHttpResponse;

import java.util.Set;

public class GateWayURLTreeMapper implements GateWayURLMapper{

    private URLTreeNode root;
    @Override
    public GateWayHttpResponse map(GateWayHttpRequest request) {


        return null;
    }


    static class URLTreeNode{
        private URLTreeNode parent;
        private Set<URLTreeNode> children;
        private boolean isLeaf;
        private String url;
    }

}
