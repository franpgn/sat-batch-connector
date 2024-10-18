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
        "cnpj",
        "nome"
})
@NoArgsConstructor
@Getter
@Setter
public class InfContribuinte {
    @XmlElement(name = "CNPJ")
    private String cnpj;
    @XmlElement(name = "xNome")
    private String nome;
}
