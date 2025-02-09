package com.primeiro.projeto.pedido.controller;

import com.primeiro.projeto.pedido.model.Pedido;
import com.primeiro.projeto.pedido.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("pedido")

public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping("{id}")
    public Pedido getPedidoById(@PathVariable Integer id){
        return pedidoService.getPedidoById(id);
    }

    @PostMapping("")
    public Pedido criaPedido(@RequestBody Pedido pedido){
        pedidoService.criaPedido(pedido);
        return pedido;
    }
}
