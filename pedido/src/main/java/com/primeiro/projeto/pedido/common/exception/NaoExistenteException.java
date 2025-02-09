package com.primeiro.projeto.pedido.common.exception;

public class NaoExistenteException extends RuntimeException{

    public NaoExistenteException() {
    }

    public NaoExistenteException(String message) {
        super(message);
    }
}
