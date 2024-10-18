package com.connector.sat.service;

import com.connector.sat.model.*;
import jakarta.persistence.*;
import jakarta.xml.bind.JAXBContext;
import lombok.*;
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
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity(name = "sat_response")
@Table(name = "sat_response")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class SATResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "nSat")
    private String nSat;
    private Date envio;
    private Date recebimento;
    private Integer cupons;
    private String situacaoLote;
    @OneToMany(mappedBy = "satResponse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cupom> cupomList;

    public SATResponse(String nSat, Date envio, Date recebimento, Integer cupons, String situacaoLote, List<Cupom> cuponsList) {
        this.nSat = nSat;
        this.envio = envio;
        this.recebimento = recebimento;
        this.cupons = cupons;
        this.situacaoLote = situacaoLote;
        this.cupomList = cuponsList;
    }

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
