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
public class ProdutosDoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer idProdPedido;

    @Column
    @Nonnull
    @Getter @Setter
    private Integer quantidadeProduto;

    @ManyToOne
    @JoinColumn(name = "idCabPedido", nullable = false)
    @Getter @Setter
    private CabeçalhoDePedido idCabPedido;
}
