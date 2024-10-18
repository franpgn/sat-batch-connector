package com.connector.sat.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.Date;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@NoArgsConstructor
@Getter
@Setter
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
}
