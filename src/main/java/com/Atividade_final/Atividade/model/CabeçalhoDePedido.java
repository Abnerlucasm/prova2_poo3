package com.Atividade_final.Atividade.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CabeçalhoDePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer idCabPedido;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    @Getter @Setter
    private Cliente cliente;

}
