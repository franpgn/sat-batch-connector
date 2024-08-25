package com.connector.sat.model;

import jakarta.xml.bind.annotation.XmlElement;

public class InfContribuinte {
    private String cnpj;
    private String nome;

    public InfContribuinte() {
    }

    public String getCnpj() {
        return cnpj;
    }

    @XmlElement(name = "CNPJ")
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    @XmlElement(name = "xNome")
    public void setNome(String nome) {
        this.nome = nome;
    }
}
