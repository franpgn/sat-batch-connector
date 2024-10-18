package com.connector.sat.service;

public record CupomDTO(String nSat, String chaveCfe, Integer nCupom, String situacao) {
    public CupomDTO(Cupom cupom) {
        this(cupom.getNSat(), cupom.getChaveCfe(), cupom.getNCupom(), cupom.getSituacao());
    }
}
