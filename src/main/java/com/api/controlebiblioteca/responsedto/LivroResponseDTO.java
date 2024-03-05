package com.api.controlebiblioteca.responsedto;

import com.api.controlebiblioteca.entity.Livro;
import com.api.controlebiblioteca.entity.Situacao;

import java.time.LocalDate;

public record LivroResponseDTO(Long id, String titulo, String autor, String genero, String isbn,
                               LocalDate dataPublicacao, String descricao, String imagem, Situacao situacao) {

    public LivroResponseDTO(Livro livro){
       this(livro.getId(),
               livro.getTitulo(),
               livro.getAutor(),
               livro.getGenero(),
               livro.getIsbn(),
               livro.getDataPublicacao(),
               livro.getDescricao(),
               livro.getImagem(),
               livro.getSituacao());

    }
}
