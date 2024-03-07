package com.api.controlebiblioteca.service;

import com.api.controlebiblioteca.entity.Livro;
import com.api.controlebiblioteca.entity.Situacao;
import com.api.controlebiblioteca.exceptionhandler.LivroNaoDisponivelException;
import com.api.controlebiblioteca.exceptionhandler.LivroNaoEncontradoException;
import com.api.controlebiblioteca.repository.LivroRepository;
import com.api.controlebiblioteca.responsedto.LivroResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public LivroResponseDTO emprestarLivro(Long id) {
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if (livroOptional.isPresent()) {
            Livro livro = livroOptional.get();
            if (livro.getSituacao() == Situacao.DISPONIVEL) {
                livro.setSituacao(Situacao.EMPRESTADO);
                livroRepository.save(livro);
                return new LivroResponseDTO(livro);
            } else {
                throw new LivroNaoDisponivelException("O Livro não está disponivel para emprestimo");
            }
        } else {
            throw new LivroNaoEncontradoException("Não foi possivel encontrar o livro");
        }
    }

    public LivroResponseDTO devolverLivro(Long id) {
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if (livroOptional.isPresent()) {
            Livro livro = livroOptional.get();
            if (livro.getSituacao() == Situacao.EMPRESTADO || livro.getSituacao() == Situacao.RESERVADO) {
                livro.setSituacao(Situacao.DISPONIVEL);
                livroRepository.save(livro);
                return new LivroResponseDTO(livro);
            } else {
                throw new LivroNaoDisponivelException("O Livro não está emprestado ou reservado");
            }
        } else {
            throw new LivroNaoEncontradoException("Não foi possível encontrar o livro");
        }
    }

    public LivroResponseDTO reservarLivro(Long id) {
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if (livroOptional.isPresent()) {
            Livro livro = livroOptional.get();
            if (livro.getSituacao() == Situacao.DISPONIVEL) {
                livro.setSituacao(Situacao.RESERVADO);
                livroRepository.save(livro);
                return new LivroResponseDTO(livro);
            } else {
                throw new LivroNaoDisponivelException("O Livro não está disponivel para emprestimo");
            }
        } else {
            throw new LivroNaoEncontradoException("Não foi possivel encontrar o livro");
        }
    }
}