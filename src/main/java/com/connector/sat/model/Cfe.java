package com.connector.sat.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cfe", propOrder = {
        "chave",
        "nCupom",
        "situacao"
})
public class Cfe {
    @XmlElement(name = "Chave")
    private String chave;
    @XmlElement(name = "nCupom")
    private String nCupom;
    @XmlElement(name = "Situacao")
    private String situacao;
    @XmlTransient
    private String cfeErros;

    public Cfe() {
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getnCupom() {
        return nCupom;
    }

    public void setnCupom(String nCupom) {
        this.nCupom = nCupom;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getCfeErros() {
        return cfeErros;
    }

    public void setCfeErros(String cfeErros) {
        this.cfeErros = cfeErros;
    }
}
