package com.connector.sat.repository;

import com.connector.sat.service.Cupom;
import com.connector.sat.service.SATResponse;

import java.util.List;

public interface SATRepository {
    void save(SATResponse satResponse);
    SATResponse findBySAT(String nSat);
    SATResponse findByID(Long id);
    List<SATResponse> findAll();
    List<Cupom> findAllCuponsResponse(Long id);
    List<Cupom> findAllSATCupons(Long nSat);
    List<Cupom> findAllCupons();
}