package com.connector.sat.model;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resLote", propOrder = {
        "infContribuinte",
        "mensagem",
        "lote",
        "signature"
})
@NoArgsConstructor
@Getter
@Setter
public class ResLote {
    @XmlElement(name = "infContribuinte")
    private InfContribuinte infContribuinte;
    @XmlElement(name = "Mensagem")
    private String mensagem;
    @XmlElement(name = "Lote")
    private Lote lote;
    @XmlElement(name = "Signature")
    private Signature signature;
}
