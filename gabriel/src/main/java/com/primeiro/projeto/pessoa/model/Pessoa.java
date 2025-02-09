package com.primeiro.projeto.pessoa.model;

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
