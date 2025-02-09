package com.primeiro.projeto.pessoa.controller;

import com.primeiro.projeto.pessoa.common.NaoExistenteException;
import com.primeiro.projeto.pessoa.model.Erro;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerErrorAdvice {



    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NaoExistenteException.class)
    public Erro handleNaoExistente(HttpServletRequest req, Exception ex){

        return Erro.builder()
                .message(ex.getMessage())
                .build();

    }
}
