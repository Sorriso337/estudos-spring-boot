package com.primeiro.projeto.pedido.service;

import com.primeiro.projeto.pedido.model.Pedido;
import com.primeiro.projeto.pedido.model.Pessoa;
import com.primeiro.projeto.pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final PessoaService pessoaService;

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
}
