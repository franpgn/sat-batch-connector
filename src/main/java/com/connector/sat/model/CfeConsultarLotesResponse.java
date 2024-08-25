package com.connector.sat.model;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "CfeConsultarLotesResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class CfeConsultarLotesResponse {
    @XmlElement(name = "CfeConsultarLotesResult")
    private CfeConsultarLotesResult cfeConsultarLotesResult;

    public CfeConsultarLotesResponse() {
    }

    public CfeConsultarLotesResult getCfeConsultarLotesResult() {
        return cfeConsultarLotesResult;
    }

    public void setCfeConsultarLotesResult(CfeConsultarLotesResult cfeConsultarLotesResult) {
        this.cfeConsultarLotesResult = cfeConsultarLotesResult;
    }
}
