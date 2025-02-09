package com.primeiro.projeto.pedido.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pedido {

    private Integer id;
    private String numeroPedido;
    private String valorTotal;
    private Integer pessoaId;
    private Pessoa pessoa;

}
