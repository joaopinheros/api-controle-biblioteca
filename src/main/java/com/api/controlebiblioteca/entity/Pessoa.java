package com.api.controlebiblioteca.entity;

import com.api.controlebiblioteca.requestdto.PessoaRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

// Criando Contrutores e manipuladores de variaveis com o Lombok
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity(name = "pessoa")
@Table(name = "pessoa")

public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private Endereco endereco;

    public Pessoa(PessoaRequestDTO data){
        this.nome = data.nome();
        this.email = data.email();
        this.telefone = data.telefone();
        this.cpf = data.cpf();
        this.endereco = data.endereco();
    }

}
