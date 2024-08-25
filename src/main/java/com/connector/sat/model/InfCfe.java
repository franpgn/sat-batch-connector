package com.connector.sat.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "cfe"
})
public class InfCfe {
    @XmlElement(name = "Cfe")
    private Cfe cfe;

    public InfCfe() {
    }

    public Cfe getCfe() {
        return cfe;
    }

    public void setCfe(Cfe cfe) {
        this.cfe = cfe;
    }
}
