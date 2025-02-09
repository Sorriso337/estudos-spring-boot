package com.primeiro.projeto.venda.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Pessoa {

    private Integer id;
    private String nome;
    private Integer idade;
    private Endereco endereco;
}
