package com.primeiro.projeto.pessoa.repository;

import com.primeiro.projeto.pessoa.model.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PessoaRepositoryTest {

    @InjectMocks
    private PessoaRepository pessoaRepository;




    @Test
    public void testPessoaRepository(){

        Pessoa pessoa = Pessoa.builder()
            .id(1)
            .nome("Teste")
            .build();

        pessoaRepository.salvaPessoa(pessoa);

        Pessoa pessoa2 = pessoaRepository.getById(pessoa.getId());

        Assertions.assertEquals(pessoa,pessoa2);

    }


}
