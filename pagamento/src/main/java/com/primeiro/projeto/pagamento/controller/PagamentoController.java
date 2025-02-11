package com.primeiro.projeto.pagamento.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("pagamento")
public class PagamentoController {

    private final SqsTemplate sqsTemplate;
    private final ObjectMapper objectMapper;

    @PostMapping("{vendaId}")
    public void confirmarPagamento(@PathVariable String vendaId){

        log.info("Enviando Pagamento");
        sqsTemplate.send(to -> to.queue("pagamento").payload(vendaId));
        log.info("pagamento enviado");
    }
}
