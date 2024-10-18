package com.connector.sat.model;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "signatureValue"
})
@NoArgsConstructor
@Getter
@Setter
public class Signature {
    @XmlTransient
    private String signedInfo;
    @XmlElement(name = "SignatureValue")
    private String signatureValue;
    @XmlTransient
    private String keyInfo;
}
