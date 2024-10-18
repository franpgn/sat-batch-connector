package com.connector.sat.service;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "cfe")
@Table(name = "cfe")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Cupom {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nSat;
    private String chaveCfe;
    private Integer nCupom;
    private String situacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nSat", referencedColumnName = "nSat", insertable = false, updatable = false)
    private SATResponse satResponse;

    public Cupom(String nSat, String chaveCfe, Integer nCupom, String situacao) {
        this.nSat = nSat;
        this.chaveCfe = chaveCfe;
        this.nCupom = nCupom;
        this.situacao = situacao;
    }
}
