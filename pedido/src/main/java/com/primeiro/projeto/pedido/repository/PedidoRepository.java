package com.primeiro.projeto.pedido.repository;

import com.primeiro.projeto.pedido.common.NaoExistenteException;
import com.primeiro.projeto.pedido.model.Pedido;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PedidoRepository {

    private final static Map<Integer, Pedido> pedidos = new HashMap<>();

    public static void criaPedido(Integer id, Pedido pedido){
        pedidos.put(pedido.getId(),pedido);
    }

    public Pedido getById(Integer id){
        Pedido pedido = pedidos.get(id);

        if(pedido == null){
            throw new NaoExistenteException("Pedido inexistente");
        }

        return pedido;
    }
}
