package com.api.controlebiblioteca.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

// Criando Getters e Setters com o lombok
@Getter
@Setter

@Embeddable
public class Endereco {
    private String Rua;
    private String numero;
    private String complemento;
    private String Bairro;
    private String cep;
    private String cidade;
    private String estado;


}
