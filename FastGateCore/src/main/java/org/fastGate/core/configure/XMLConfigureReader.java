package org.fastGate.core.configure;

import org.apache.commons.lang3.StringUtils;
import org.fastGate.core.GateWayServerStartException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLConfigureReader implements ConfigureReader{
    private File configureFile;
    private DocumentBuilder documentBuilder;
    public XMLConfigureReader(String configureFilePath) throws GateWayServerStartException {
        this(new File(configureFilePath));

    }


    public XMLConfigureReader(File configureFile) throws GateWayServerStartException {
        if (!configureFile.exists()||!configureFile.isFile())
            throw new GateWayServerStartException("Configure file not exist or not valid");
        this.configureFile=configureFile;
        DocumentBuilderFactory docFactory=DocumentBuilderFactory.newInstance();
        try {
            documentBuilder=docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new GateWayServerStartException("Try to create Dom parser failed");
        }
    }


    @Override
    public PropertyConfigure read() throws GateWayServerStartException{
        try {
            Document root= documentBuilder.parse(configureFile);

            NodeList rootList= root.getElementsByTagName("fastgate");
            if (rootList.getLength()==0) {
                throw new GateWayServerStartException("RootNode 'fastgate' not existing");
            }
            Node rootNode=rootList.item(0);
            if (rootNode.getChildNodes().getLength()==0) {
                throw new GateWayServerStartException("configure file not valid");
            }
            NodeList configList=rootNode.getChildNodes();
            for (int i=0;i<configList.getLength();i++){

            }



        } catch (SAXException |IOException e) {
            throw new GateWayServerStartException("Parsing fastgate.xml failed");
        }
        return null;
    }

    public static void main(String[] args) throws GateWayServerStartException {
        System.out.println(XMLConfigureReader.class.getClassLoader().getResource("fastgate.xml").getPath());

        XMLConfigureReader xmlConfigureReader=new XMLConfigureReader(XMLConfigureReader.class.getClassLoader().getResource("fastgate.xml").getPath());
        xmlConfigureReader.read();
    }
}
