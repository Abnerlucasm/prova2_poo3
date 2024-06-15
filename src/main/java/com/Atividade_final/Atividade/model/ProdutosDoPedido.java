package com.Atividade_final.Atividade.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
public class ProdutosDoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProdPedido;
    @Column
    @Nonnull
    private Integer quantidadeProduto;
    @ManyToOne
    @JoinColumn(name = "idCabPedido", nullable = false)
    private CabeçalhoDePedido idCabPedido;
}
