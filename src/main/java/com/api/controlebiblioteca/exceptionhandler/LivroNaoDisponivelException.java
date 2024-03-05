package com.api.controlebiblioteca.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LivroNaoDisponivelException extends RuntimeException{
    public LivroNaoDisponivelException(String mensagem){
        super(mensagem);
    }
}
