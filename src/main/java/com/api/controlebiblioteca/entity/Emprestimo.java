package com.api.controlebiblioteca.entity;

import com.api.controlebiblioteca.requestdto.EmprestimoRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

//Anotações do Lombok para geração de getters e setters automaticos.
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity(name = "emprestimo")
@Table(name = "emprestimo")

public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(EmprestimoRequestDTO data) {
        this.pessoa = data.pessoa();
        this.livro = data.livro();
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = data.dataDevolucao();
    }
}
