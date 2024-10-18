package com.connector.sat.service;

import java.util.Date;

public record SATResponseDTO(String nSat, Date envio, Date recebimento, Integer cupons, String situacaoLote) {
    public SATResponseDTO(SATResponse satResponse) {
        this(satResponse.getNSat(), satResponse.getEnvio(), satResponse.getRecebimento(), satResponse.getCupons(), satResponse.getSituacaoLote());
    }
}
