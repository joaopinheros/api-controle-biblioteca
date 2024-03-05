package com.api.controlebiblioteca.service;

import com.api.controlebiblioteca.entity.Emprestimo;
import com.api.controlebiblioteca.requestdto.EmprestimoRequestDTO;
import com.api.controlebiblioteca.responsedto.EmprestimoResponseDTO;
import com.api.controlebiblioteca.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmprestimoService {

    @Autowired
    private LivroService livroService;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public Emprestimo criarEmprestimo(EmprestimoRequestDTO data) {

        // Verificar se o livro ainda está disponível para empréstimo
        livroService.emprestarLivro(data.livro().getId());

        // Verificar se a pessoa está cadastrada
        pessoaService.verificarPessoaCadastrada(data.pessoa().getId());

        Emprestimo emprestimo = new Emprestimo(data);

        // Salvar o empréstimo no repositório
        emprestimoRepository.save(emprestimo);

        return emprestimo;
    }
}
