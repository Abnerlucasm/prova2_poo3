package com.Atividade_final.Atividade.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    @Column
    @Nonnull
    @Getter @Setter
    private String nome;

    @Column
    @Nonnull
    @Getter @Setter
    private Integer quantidadeEstoque = 0;

    @Column
    @Nonnull
    @Getter @Setter
    private Double valorVenda = 0.0;

}
