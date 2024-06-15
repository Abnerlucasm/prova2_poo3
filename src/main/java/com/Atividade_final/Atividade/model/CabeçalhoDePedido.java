package com.Atividade_final.Atividade.model;

import jakarta.persistence.*;

import java.util.Map;

@Entity
public class CabeçalhoDePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCabPedido;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente cliente;

}
