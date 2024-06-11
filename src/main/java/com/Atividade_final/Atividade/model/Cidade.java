package com.Atividade_final.Atividade.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCidade;
    @Column
    @Nonnull
    private String nomeCidade;
    @Column
    @Nonnull String ufCidade;
}
