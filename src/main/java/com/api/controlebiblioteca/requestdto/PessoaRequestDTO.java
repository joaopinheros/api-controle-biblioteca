package com.api.controlebiblioteca.requestdto;

import com.api.controlebiblioteca.entity.Endereco;

public record PessoaRequestDTO(String nome, String email, String telefone, String cpf, Endereco endereco) {
}
