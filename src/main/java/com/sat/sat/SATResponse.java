package com.sat.sat;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SATResponse {

    public static String extractCDATA(String response) {
        Pattern cdataPattern = Pattern.compile("<!\\[CDATA\\[(.*?)\\]\\]>", Pattern.DOTALL);
        Matcher matcher = cdataPattern.matcher(response);

        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return "Invalid document";
    }

//    public static SATResponse readSATResponse(String response) throws JAXBException {
//        String cdata = extractCDATA(response);
//
//        JAXBContext jaxbContext = JAXBContext.newInstance(ResLote.class);
//        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//
//        StringReader reader = new StringReader(cdata);
//        ResLote resLote = (ResLote) unmarshaller.unmarshal(reader);
//
//    }
}
