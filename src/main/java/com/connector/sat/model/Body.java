package com.connector.sat.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "cfeConsultarLotesResponse"
})
@NoArgsConstructor
@Getter
@Setter
public class Body {
    @XmlElement(name = "CfeConsultarLotesResponse", namespace = "http://www.fazenda.sp.gov.br/sat/wsdl/CfeConsultaLotes")
    private CfeConsultarLotesResponse cfeConsultarLotesResponse;
}
