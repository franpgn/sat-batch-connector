package com.connector.sat.model;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resLote", propOrder = {
        "infContribuinte",
        "mensagem",
        "lote",
        "signature"
})
public class ResLote {
    @XmlElement(name = "infContribuinte")
    private InfContribuinte infContribuinte;
    @XmlElement(name = "Mensagem")
    private String mensagem;
    @XmlElement(name = "Lote")
    private Lote lote;
    @XmlElement(name = "Signature")
    private Signature signature;

    public ResLote() {
    }

    public InfContribuinte getInfContribuinte() {
        return infContribuinte;
    }

    public void setInfContribuinte(InfContribuinte infContribuinte) {
        this.infContribuinte = infContribuinte;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public Signature getSignature() {
        return signature;
    }

    public void setSignature(Signature signature) {
        this.signature = signature;
    }
}
