package com.api.controlebiblioteca.requestdto;

import com.api.controlebiblioteca.entity.Situacao;

import java.time.LocalDate;

public record LivroRequestDTO(String titulo, String autor, String genero, String isbn,
                              LocalDate dataPublicacao, String descricao, String imagem, Situacao situacao) {
}
