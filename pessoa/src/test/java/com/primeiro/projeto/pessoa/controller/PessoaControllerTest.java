package com.primeiro.projeto.pessoa.controller;

import com.primeiro.projeto.pessoa.model.Pessoa;
import com.primeiro.projeto.pessoa.repository.PessoaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PessoaControllerTest {

    @InjectMocks
    private PessoaController pessoaController;

    @Mock
    private PessoaRepository pessoaRepository;


    @Test
    public void testListNaoRetornaNada(){

        Mockito.when(pessoaRepository.listPessoas()).thenReturn(Collections.emptyList());

        Collection<Pessoa> pessoas = pessoaController.getPessoas();

        Assertions.assertEquals(0,pessoas.size());
    }

    @Test
    public void testListRetornaPessoas(){

        Pessoa pessoa = Pessoa.builder()
                .nome("Pessoa cadastrada")
                .build();

        Mockito.when(pessoaRepository.listPessoas()).thenReturn(List.of(pessoa));

        Collection<Pessoa> pessoas = pessoaController.getPessoas();

        Assertions.assertEquals(1,pessoas.size());
    }

    @Test
    public void testRetornaPessoaPorId(){

        Pessoa pessoa = Pessoa.builder()
                .id(1)
                .nome("Pessoas cadastrada")
                .build();

        Mockito.when(pessoaRepository.getById(pessoa.getId())).thenReturn(pessoa);

        pessoaController.postPessoa(pessoa);
        Pessoa pessoaCriada = pessoaController.getPessoaPorId(pessoa.getId());

        Assertions.assertEquals(pessoa.getId(), pessoaCriada.getId());
    }
}
