package com.connector.sat.service;

public class SOAPBuilder {

    public static String buildSATRequest(SATRequest request) {
        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
                +"xmlns:cfec=\"http://www.fazenda.sp.gov.br/sat/wsdl/CfeConsultaLotes\">"
                +"<soapenv:Header>"
                +"<cfec:cfeCabecMsg>"
                +"<cfec:cUF>" + request.getUf() + "</cfec:cUF>"
                +"<cfec:versaoDados>0.06</cfec:versaoDados>"
                +"</cfec:cfeCabecMsg>"
                +"</soapenv:Header>"
                +"<soapenv:Body><cfec:CfeConsultarLotes><cfec:cfeDadosMsg>"
                +"<![CDATA[<consLote xmlns=\"http://www.fazenda.sp.gov.br/sat\" versao=\"0.06\">"
                +"<nserieSAT>" + request.getNSerieSAT() + "</nserieSAT>"
                +"<dhInicial>" + request.getDhInicial() + "</dhInicial>"
                +"<dhFinal>" + request.getDhFinal() + "</dhFinal>"
                +"<chaveSeguranca>" + request.getChaveSeguranca() + "</chaveSeguranca>"
                +"</consLote>]]></cfec:cfeDadosMsg>"
                +"</cfec:CfeConsultarLotes></soapenv:Body>"
                +"</soapenv:Envelope>";
    }
}
