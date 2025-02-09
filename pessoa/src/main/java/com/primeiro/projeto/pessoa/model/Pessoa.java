package com.primeiro.projeto.pessoa.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Pessoa {

    private Integer id;
    private String nome;
    private Integer idade;
    private Endereco endereco;

}
