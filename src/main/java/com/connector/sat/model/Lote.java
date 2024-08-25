package com.connector.sat.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.Date;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Lote", propOrder = {
        "nRec",
        "dhEnvioLote",
        "dhProcessamento",
        "tipoLote",
        "origem",
        "qtdeCupoms",
        "situacaoLote",
        "infCfe"
})
public class Lote {
    @XmlElement(name = "NRec")
    private String nRec;
    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlElement(name = "dhEnvioLote")
    private Date dhEnvioLote;
    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlElement(name = "dhProcessamento")
    private Date dhProcessamento;
    @XmlElement(name = "TipoLote")
    private String tipoLote;
    @XmlElement(name = "Origem")
    private String origem;
    @XmlElement(name = "QtdeCupons")
    private String qtdeCupoms;
    @XmlElement(name = "SituacaoLote")
    private String situacaoLote;
    @XmlElement(name = "InfCfe")
    private InfCfe infCfe;

    public Lote() {
    }

    public String getnRec() {
        return nRec;
    }

    public void setnRec(String nRec) {
        this.nRec = nRec;
    }

    public Date getDhEnvioLote() {
        return dhEnvioLote;
    }

    public void setDhEnvioLote(Date dhEnvioLote) {
        this.dhEnvioLote = dhEnvioLote;
    }

    public Date getDhProcessamento() {
        return dhProcessamento;
    }

    public void setDhProcessamento(Date dhProcessamento) {
        this.dhProcessamento = dhProcessamento;
    }

    public String getTipoLote() {
        return tipoLote;
    }

    public void setTipoLote(String tipoLote) {
        this.tipoLote = tipoLote;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getQtdeCupoms() {
        return qtdeCupoms;
    }

    public void setQtdeCupoms(String qtdeCupoms) {
        this.qtdeCupoms = qtdeCupoms;
    }

    public String getSituacaoLote() {
        return situacaoLote;
    }

    public void setSituacaoLote(String situacaoLote) {
        this.situacaoLote = situacaoLote;
    }

    public InfCfe getInfCfe() {
        return infCfe;
    }

    public void setInfCfe(InfCfe infCfe) {
        this.infCfe = infCfe;
    }
}
