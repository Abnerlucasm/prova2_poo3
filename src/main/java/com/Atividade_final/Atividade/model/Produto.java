package com.Atividade_final.Atividade.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Nonnull
    private String nome;

    @Column
    @Nonnull
    private Integer quantidadeEstoque = 0;

    @Column
    @Nonnull
    private Double valorVenda = 0.0;

}
