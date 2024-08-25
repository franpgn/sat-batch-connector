package com.connector.sat.model;


import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class CfeConsultarLotesResult {
    @XmlElement(name = "resLote")
    private ResLote resLote;

    public CfeConsultarLotesResult() {
    }

    public ResLote getResLote() {
        return resLote;
    }

    public void setResLote(ResLote resLote) {
        this.resLote = resLote;
    }
}
