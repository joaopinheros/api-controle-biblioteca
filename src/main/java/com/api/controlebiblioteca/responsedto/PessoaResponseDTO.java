package com.api.controlebiblioteca.responsedto;

import com.api.controlebiblioteca.entity.Endereco;
import com.api.controlebiblioteca.entity.Pessoa;

import java.util.UUID;

public record PessoaResponseDTO(UUID id, String nome, String email, String telefone, String cpf, Endereco endereco) {

    // Dados que serão enviados do servidor para o cliente como resposta a uma requisição.

    public PessoaResponseDTO(Pessoa pessoa){
        this(pessoa.getId(),
                pessoa.getNome(),
                pessoa.getEmail(),
                pessoa.getTelefone(),
                pessoa.getCpf(),
                pessoa.getEndereco());
    }
}
