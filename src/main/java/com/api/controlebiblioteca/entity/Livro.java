package com.api.controlebiblioteca.entity;

import com.api.controlebiblioteca.requestdto.LivroRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity(name = "livro")
@Table(name = "livro")

public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;
    private String autor;
    private String genero;
    private String isbn;
    private LocalDate dataPublicacao;
    private String descricao;
    private String imagem;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;



    //Construtor para o recebimento de requisições

    public Livro(LivroRequestDTO data){
        this.titulo = data.titulo();
        this.autor = data.autor();
        this.genero = data.genero();
        this.isbn = data.isbn();
        this.dataPublicacao = data.dataPublicacao();
        this.descricao = data.descricao();
        this.imagem = data.imagem();
        this.situacao = data.situacao();
    }
}


