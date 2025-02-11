package com.primeiro.projeto.venda.listener;

import com.primeiro.projeto.venda.model.Venda;
import com.primeiro.projeto.venda.repository.VendaRepository;
import io.awspring.cloud.sqs.annotation.SqsListener;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PagamentoListener {

    private final VendaRepository vendaRepository;

    @PostConstruct
    public void postConstruct(){
        log.info("CLASSE INCIALIZADA.");
    }

    @SqsListener("pagamento")
    public void pagarVenda(@Payload String vendaId){

        Venda venda = vendaRepository.getById(vendaId);
        try{
            Thread.sleep(1500);
        }
        catch (Exception ex){
        }

        if(venda != null){
            venda.setStatus("PAGO");
            vendaRepository.salvar(venda);
        }
        else{
            log.error("Venda inexistente");
        }

    }
}
