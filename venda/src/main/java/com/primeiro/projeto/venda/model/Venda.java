package com.primeiro.projeto.venda.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder

public class Venda {

    private String id;
    private String numeroVendas;
    private BigDecimal valorTotal;
    private String status;
    private Pedido pedido;


}
