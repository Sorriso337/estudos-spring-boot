package com.primeiro.projeto.pessoa.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Endereco {
    private String logradouro;
    private String numero;
}
