package com.sat.sat;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "resLote")
public class ResLote {

    private InfContribuinte infContribuinte;
    private Lote lote;

    @XmlElement(name = "infContribuinte")
    public InfContribuinte getInfContribuinte() {
        return infContribuinte;
    }

    public void setInfContribuinte(InfContribuinte infContribuinte) {
        this.infContribuinte = infContribuinte;
    }

    @XmlElement(name = "Lote")
    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }
}

class InfContribuinte {
    private String cnpj;
    private String xNome;

    @XmlElement(name = "CNPJ")
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @XmlElement(name = "xNome")
    public String getXNome() {
        return xNome;
    }

    public void setXNome(String xNome) {
        this.xNome = xNome;
    }
}

class Lote {
    private String nRec;
    private String dhEnvioLote;
    private String dhProcessamento;
    private String tipoLote;
    private String origem;
    private int qtdeCupoms;
    private String situacaoLote;
    private InfCfe infCfe;

    @XmlElement(name = "NRec")
    public String getNRec() {
        return nRec;
    }

    public void setNRec(String nRec) {
        this.nRec = nRec;
    }

    @XmlElement(name = "dhEnvioLote")
    public String getDhEnvioLote() {
        return dhEnvioLote;
    }

    public void setDhEnvioLote(String dhEnvioLote) {
        this.dhEnvioLote = dhEnvioLote;
    }

    @XmlElement(name = "dhProcessamento")
    public String getDhProcessamento() {
        return dhProcessamento;
    }

    public void setDhProcessamento(String dhProcessamento) {
        this.dhProcessamento = dhProcessamento;
    }

    @XmlElement(name = "TipoLote")
    public String getTipoLote() {
        return tipoLote;
    }

    public void setTipoLote(String tipoLote) {
        this.tipoLote = tipoLote;
    }

    @XmlElement(name = "Origem")
    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    @XmlElement(name = "QtdeCupoms")
    public int getQtdeCupoms() {
        return qtdeCupoms;
    }

    public void setQtdeCupoms(int qtdeCupoms) {
        this.qtdeCupoms = qtdeCupoms;
    }

    @XmlElement(name = "SituacaoLote")
    public String getSituacaoLote() {
        return situacaoLote;
    }

    public void setSituacaoLote(String situacaoLote) {
        this.situacaoLote = situacaoLote;
    }

    @XmlElement(name = "InfCfe")
    public InfCfe getInfCfe() {
        return infCfe;
    }

    public void setInfCfe(InfCfe infCfe) {
        this.infCfe = infCfe;
    }
}

class InfCfe {
    private Cfe cfe;

    @XmlElement(name = "Cfe")
    public Cfe getCfe() {
        return cfe;
    }

    public void setCfe(Cfe cfe) {
        this.cfe = cfe;
    }
}

class Cfe {
    private String chave;
    private String nCupom;
    private String situacao;

    @XmlElement(name = "Chave")
    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    @XmlElement(name = "nCupom")
    public String getNCupom() {
        return nCupom;
    }

    public void setNCupom(String nCupom) {
        this.nCupom = nCupom;
    }

    @XmlElement(name = "Situacao")
    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
