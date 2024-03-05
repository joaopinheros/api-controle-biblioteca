package com.api.controlebiblioteca.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class PessoaNaoCadastradaException extends RuntimeException{
    public PessoaNaoCadastradaException(String mensagem){
        super(mensagem);
    }
}
