package com.Atividade_final.Atividade.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @Column
    @Nonnull
    private String nomeCliente;

}
