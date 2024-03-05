package com.api.controlebiblioteca.service;

import com.api.controlebiblioteca.entity.Pessoa;
import com.api.controlebiblioteca.exceptionhandler.PessoaNaoCadastradaException;
import com.api.controlebiblioteca.repository.PessoaRepository;
import com.api.controlebiblioteca.responsedto.PessoaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaResponseDTO verificarPessoaCadastrada(UUID id) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
        if (pessoaOptional.isPresent()) {
            Pessoa pessoa = pessoaOptional.get();
            return new PessoaResponseDTO(pessoa);
        } else {
            throw new PessoaNaoCadastradaException("É necessário cadastrar uma pessoa para o empréstimo");
        }
    }
}
