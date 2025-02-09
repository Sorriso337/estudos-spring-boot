package com.primeiro.projeto.pedido.common;

public class NaoExistenteException extends RuntimeException{

    public NaoExistenteException() {
    }

    public NaoExistenteException(String message) {
        super(message);
    }
}
