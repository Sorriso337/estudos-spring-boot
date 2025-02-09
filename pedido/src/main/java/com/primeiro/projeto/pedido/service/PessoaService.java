package com.primeiro.projeto.pedido.service;

import com.primeiro.projeto.pedido.common.NaoExistenteException;
import com.primeiro.projeto.pedido.model.Pessoa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PessoaService {

    public Pessoa getPessoaById(Integer id){

        RestTemplate client = new RestTemplate();
        ResponseEntity<Pessoa> responseEntity =  client.getForEntity("http://localhost:8080/pessoa/"+id,Pessoa.class);

        if(!HttpStatus.OK.equals(responseEntity.getStatusCode())){
            throw new NaoExistenteException("Erro ao retornar usuário");
        }

        return responseEntity.getBody();
    }
}
