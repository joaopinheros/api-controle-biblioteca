package com.api.controlebiblioteca.requestdto;

import com.api.controlebiblioteca.entity.Livro;
import com.api.controlebiblioteca.entity.Pessoa;
import com.api.controlebiblioteca.entity.Situacao;

import java.time.LocalDate;

public record EmprestimoRequestDTO(Pessoa pessoa, Livro livro, LocalDate dataEmprestimo,
                                   LocalDate dataDevolucao) {
}
