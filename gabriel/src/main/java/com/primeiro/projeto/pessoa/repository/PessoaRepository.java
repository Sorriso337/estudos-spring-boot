package com.primeiro.projeto.pessoa.repository;

import com.primeiro.projeto.pessoa.common.NaoExistenteException;
import com.primeiro.projeto.pessoa.model.Pessoa;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PessoaRepository {

    private final static Map<Integer, Pessoa> pessoas = new HashMap<>();

    public Collection<Pessoa> listPessoas(){

        return pessoas.values();
    }

    public Pessoa getById(Integer id){
        Pessoa pessoa= pessoas.get(id);

        if(pessoa == null){
            throw new NaoExistenteException("Pessoa inexistente");
        }

        return pessoa;
    }

    public void salvaPessoa(Pessoa pessoa){
        pessoas.put(pessoa.getId(),pessoa);
    }
}
