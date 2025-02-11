package com.primeiro.projeto.venda.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pedido {

    private Integer id;
    private String valorTotal;
    private Integer pessoaId;
    private Pessoa pessoa;

}
