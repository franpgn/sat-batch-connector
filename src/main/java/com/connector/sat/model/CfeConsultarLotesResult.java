package com.connector.sat.model;


import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@Getter
@Setter
public class CfeConsultarLotesResult {
    @XmlElement(name = "resLote")
    private ResLote resLote;
}
