package com.primeiro.projeto.venda.repository;

import com.primeiro.projeto.venda.model.Pessoa;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PessoaRepository {

    public Pessoa getPessoa(Integer id) throws Exception{
        RestTemplate client = new RestTemplate();
        ResponseEntity<Pessoa> responseEntity =  client.getForEntity("http://localhost:8080/pessoa/"+id,Pessoa.class);

        if(!HttpStatus.OK.equals(responseEntity.getStatusCode())){
            throw new Exception("Erro ao retornar usuário");
        }

        return responseEntity.getBody();
    }
}
