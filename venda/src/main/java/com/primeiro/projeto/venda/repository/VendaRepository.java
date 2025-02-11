package com.primeiro.projeto.venda.repository;

import com.primeiro.projeto.venda.model.Venda;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class VendaRepository {

    private static final Map<String, Venda> vendas = new HashMap<>();

    public Venda getById(String id){
        return vendas.get(id);
    }

    public void salvar(Venda venda){
        vendas.put(venda.getId(), venda);
    }
}
