package com.primeiro.projeto.venda.listener;

import com.primeiro.projeto.venda.model.Pedido;
import com.primeiro.projeto.venda.model.Venda;
import com.primeiro.projeto.venda.repository.VendaRepository;
import io.awspring.cloud.sqs.annotation.SqsListener;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class PedidoListener {

    private final VendaRepository vendaRepository;

    @PostConstruct
    public void postConstruct(){
        log.info("CLASSE INCIALIZADA.");
    }

    @SqsListener("venda")
    public void venderPedido(@Payload Pedido pedido){
        log.info("Pedido recebido: "+pedido.getId());
        Venda venda = Venda.builder()
                .id(pedido.getId()+"venda")
                .numeroVendas(UUID.randomUUID().toString())
                .pedido(pedido)
                .status("CRIADA")
                .valorTotal(new BigDecimal(pedido.getValorTotal()))
                .build();
        vendaRepository.salvar(venda);
        log.info("Venda criada");

    }
}
