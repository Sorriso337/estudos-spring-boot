package com.primeiro.projeto.venda.listener;

import com.primeiro.projeto.venda.model.Pedido;
import io.awspring.cloud.sqs.annotation.SqsListener;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PedidoListener {


    @PostConstruct
    public void postConstruct(){
        log.info("CLASSE INCIALIZADA.");
    }

    @SqsListener("venda")
    public void venderPedido(@Payload Pedido pedido){

        log.info("Pedido recebido: "+pedido.getId());

    }
}
