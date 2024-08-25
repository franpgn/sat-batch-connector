package com.connector.sat.service;

import com.connector.sat.model.*;
import jakarta.xml.bind.JAXBContext;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;

public class SATResponse {

    public static CfeConsultarLotesResponse unmarshal(String xml) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xml.replaceAll("&gt;", ">").replaceAll("&lt;", "<"))));

        NodeList nodeList = doc.getElementsByTagNameNS("http://www.fazenda.sp.gov.br/sat/wsdl/CfeConsultaLotes", "CfeConsultarLotesResponse");
        if (nodeList.getLength() == 0) {
            throw new Exception("Tag CfeConsultarLotesResponse not found in XML.");
        }
        Node cfeResponseNode = nodeList.item(0);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(cfeResponseNode), new StreamResult(writer));

        String treatedXML = writer.toString().replace(" xmlns=\"http://www.fazenda.sp.gov.br/sat/wsdl/CfeConsultaLotes\"", "").replace("xmlns=\"http://www.w3.org/2000/09/xmldsig#\"", "");

        JAXBContext context = JAXBContext.newInstance(CfeConsultarLotesResponse.class);
        return (CfeConsultarLotesResponse) context.createUnmarshaller().unmarshal(new StringReader(treatedXML));
    }
}
