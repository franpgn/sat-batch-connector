package com.connector.sat.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SATRequest {
    private String uf;
    private String nSerieSAT;
    private String dhInicial;
    private String dhFinal;
    private String chaveSeguranca;
}
