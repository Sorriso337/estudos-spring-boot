package com.primeiro.projeto.pessoa.controller;

import com.primeiro.projeto.pessoa.model.Pessoa;
import com.primeiro.projeto.pessoa.repository.PessoaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    private final PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping
    public Collection<Pessoa> getPessoas(){
        return pessoaRepository.listPessoas();
    }

    @GetMapping("{id}")
    public Pessoa getPessoas(@PathVariable("id") Integer id){
        return pessoaRepository.getById(id);
    }

    @PostMapping
    public Pessoa postPessoa(@RequestBody Pessoa pessoa){
        pessoaRepository.salvaPessoa(pessoa);
        return pessoa;
    }
}
