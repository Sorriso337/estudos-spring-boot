package com.primeiro.projeto.pedido.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.primeiro.projeto.pedido.model.Pedido;
import com.primeiro.projeto.pedido.model.Pessoa;
import com.primeiro.projeto.pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final PessoaService pessoaService;
    private final QueueMessagingTemplate queueMessagingTemplate;
    private final ObjectMapper objectMapper;

    public void criaPedido(Pedido pedido){
        validaPessoa(pedido.getPessoaId());
        pedidoRepository.criaPedido(pedido.getId(), pedido);
    }

    public Pedido getPedidoById(Integer id){
        Pedido pedido =  pedidoRepository.getById(id);
        Pessoa pessoa = pessoaService.getPessoaById(pedido.getPessoaId());
        pedido.setPessoa(pessoa);

        return pedido;
    }

    public void validaPessoa(Integer pessoaId){
        pessoaService.getPessoaById(pessoaId);
    }

    public Pedido venderPedido(Integer pedidoId){
        log.info("vendendo pedido");
        Pedido pedido = pedidoRepository.getById(pedidoId);
        try {
           String pedidoStr = objectMapper.writeValueAsString(pedido);
            Message<String> message = MessageBuilder.withPayload(pedidoStr).build();
            queueMessagingTemplate.send("venda", message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        log.info("pedido separado pra venda.");
        return pedido;
    }
}
