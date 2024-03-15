package com.api.controlebiblioteca.service;

import com.api.controlebiblioteca.entity.Livro;
import com.api.controlebiblioteca.entity.Situacao;
import com.api.controlebiblioteca.exceptionhandler.LivroNaoDisponivelException;
import com.api.controlebiblioteca.exceptionhandler.LivroNaoEncontradoException;
import com.api.controlebiblioteca.repository.LivroRepository;
import com.api.controlebiblioteca.responsedto.LivroResponseDTO;
import com.api.controlebiblioteca.service.LivroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class LivroServiceTest {

    @Mock
    private LivroRepository livroRepository;

    @InjectMocks
    private LivroService livroService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testEmprestarLivro() {
        Livro livro = new Livro();
        livro.setSituacao(Situacao.DISPONIVEL);

        when(livroRepository.findById(1L)).thenReturn(Optional.of(livro));
        when(livroRepository.save(any(Livro.class))).thenReturn(livro);

        LivroResponseDTO responseDTO = livroService.emprestarLivro(1L);

        assertEquals(Situacao.EMPRESTADO, livro.getSituacao());
    }

    @Test
    void testEmprestarLivroNaoDisponivelException() {
        Livro livro = new Livro();
        livro.setSituacao(Situacao.EMPRESTADO);

        when(livroRepository.findById(1L)).thenReturn(Optional.of(livro));

        assertThrows(LivroNaoDisponivelException.class, () -> livroService.emprestarLivro(1L));
    }

    @Test
    void testEmprestarLivroNaoEncontradoException() {
        when(livroRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(LivroNaoEncontradoException.class, () -> livroService.emprestarLivro(1L));
    }

    @Test
    void testDevolverLivro() {
        Livro livro = new Livro();
        livro.setSituacao(Situacao.EMPRESTADO);

        when(livroRepository.findById(1L)).thenReturn(Optional.of(livro));
        when(livroRepository.save(any(Livro.class))).thenReturn(livro);

        LivroResponseDTO responseDTO = livroService.devolverLivro(1L);

        assertEquals(Situacao.DISPONIVEL, livro.getSituacao());
    }

    @Test
    void testDevolverLivroNaoDisponivelException() {
        Livro livro = new Livro();
        livro.setSituacao(Situacao.DISPONIVEL);

        when(livroRepository.findById(1L)).thenReturn(Optional.of(livro));

        assertThrows(LivroNaoDisponivelException.class, () -> livroService.devolverLivro(1L));
    }

    @Test
    void testDevolverLivroNaoEncontradoException() {
        when(livroRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(LivroNaoEncontradoException.class, () -> livroService.devolverLivro(1L));
    }

    @Test
    void testReservarLivro() {
        Livro livro = new Livro();
        livro.setSituacao(Situacao.DISPONIVEL);

        when(livroRepository.findById(1L)).thenReturn(Optional.of(livro));
        when(livroRepository.save(any(Livro.class))).thenReturn(livro);

        LivroResponseDTO responseDTO = livroService.reservarLivro(1L);

        assertEquals(Situacao.RESERVADO, livro.getSituacao());
    }

    @Test
    void testReservarLivroNaoDisponivelException() {
        Livro livro = new Livro();
        livro.setSituacao(Situacao.EMPRESTADO);

        when(livroRepository.findById(1L)).thenReturn(Optional.of(livro));

        assertThrows(LivroNaoDisponivelException.class, () -> livroService.reservarLivro(1L));
    }

    @Test
    void testReservarLivroNaoEncontradoException() {
        when(livroRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(LivroNaoEncontradoException.class, () -> livroService.reservarLivro(1L));
    }
}
