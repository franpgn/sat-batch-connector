package com.connector.sat.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cfe", propOrder = {
        "chave",
        "nCupom",
        "situacao"
})
@NoArgsConstructor
@Getter
@Setter
public class Cfe {
    @XmlElement(name = "Chave")
    private String chave;
    @XmlElement(name = "nCupom")
    private String nCupom;
    @XmlElement(name = "Situacao")
    private String situacao;
    @XmlTransient
    private String cfeErros;
}
