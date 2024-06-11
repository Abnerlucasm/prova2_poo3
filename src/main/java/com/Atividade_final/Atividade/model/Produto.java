package com.Atividade_final.Atividade.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @Nonnull
    private String nome;

    @Column
    @Nonnull
    private int quantidadeEstoque = 0;

    @Column
    @Nonnull
    private double valorVenda = 0.0;

}
