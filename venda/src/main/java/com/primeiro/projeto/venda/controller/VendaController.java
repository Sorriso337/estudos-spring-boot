package com.primeiro.projeto.venda.controller;

import com.primeiro.projeto.venda.model.Venda;
import com.primeiro.projeto.venda.repository.VendaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("venda")
public class VendaController {

    private final VendaRepository vendaRepository;


    @GetMapping("{id}")
    public Venda getById(@PathVariable("id") String id){
        log.info("Chamada do endpoint");
        try {
            return vendaRepository.getById(id);
        }
        catch (Exception error){
          //  log.error(error.getMessage(), error);
            return null;
        }
    }
}
