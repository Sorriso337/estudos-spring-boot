package com.primeiro.projeto.pessoa.common;

public class NaoExistenteException extends RuntimeException{

    public NaoExistenteException() {
    }

    public NaoExistenteException(String message) {
        super(message);
    }
}
