package com.sat.sat;

public class SATRequest {
    private String uf;
    private String nSerieSAT;
    private String dhInicial;
    private String dhFinal;
    private String chaveSeguranca;

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNSerieSAT() {
        return nSerieSAT;
    }

    public void setNSerieSAT(String nSerieSAT) {
        this.nSerieSAT = nSerieSAT;
    }

    public String getDhInicial() {
        return dhInicial;
    }

    public void setDhInicial(String dhInicial) {
        this.dhInicial = dhInicial;
    }

    public String getDhFinal() {
        return dhFinal;
    }

    public void setDhFinal(String dhFinal) {
        this.dhFinal = dhFinal;
    }

    public String getChaveSeguranca() {
        return chaveSeguranca;
    }

    public void setChaveSeguranca(String chaveSeguranca) {
        this.chaveSeguranca = chaveSeguranca;
    }
}
