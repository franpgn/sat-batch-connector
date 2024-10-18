package com.connector.sat.model;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "CfeConsultarLotesResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@Getter
@Setter
public class CfeConsultarLotesResponse {
    @XmlElement(name = "CfeConsultarLotesResult")
    private CfeConsultarLotesResult cfeConsultarLotesResult;
}
