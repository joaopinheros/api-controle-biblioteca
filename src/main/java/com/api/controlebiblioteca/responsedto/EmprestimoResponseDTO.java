package com.api.controlebiblioteca.responsedto;

import com.api.controlebiblioteca.entity.Emprestimo;
import com.api.controlebiblioteca.entity.Livro;
import com.api.controlebiblioteca.entity.Pessoa;
import com.api.controlebiblioteca.entity.Situacao;

import java.time.LocalDate;

public record EmprestimoResponseDTO(Long id, Pessoa pessoa, Livro livro, LocalDate dataEmprestimo,
                                    LocalDate dataDevolucao) {

    public EmprestimoResponseDTO(Emprestimo emprestimo){
        this(emprestimo.getId(),
                emprestimo.getPessoa(),
                emprestimo.getLivro(),
                emprestimo.getDataEmprestimo(),
                emprestimo.getDataDevolucao());
    }
}
