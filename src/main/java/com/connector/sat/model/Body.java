package com.connector.sat.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "cfeConsultarLotesResponse"
})
public class Body {
    @XmlElement(name = "CfeConsultarLotesResponse", namespace = "http://www.fazenda.sp.gov.br/sat/wsdl/CfeConsultaLotes")
    private CfeConsultarLotesResponse cfeConsultarLotesResponse;

    public Body() {
    }

    public CfeConsultarLotesResponse getCfeConsultarLotesResponse() {
        return cfeConsultarLotesResponse;
    }

    public void setCfeConsultarLotesResponse(CfeConsultarLotesResponse cfeConsultarLotesResponse) {
        this.cfeConsultarLotesResponse = cfeConsultarLotesResponse;
    }
}
