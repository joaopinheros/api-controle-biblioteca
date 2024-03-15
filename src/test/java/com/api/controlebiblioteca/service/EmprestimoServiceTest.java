package com.api.controlebiblioteca.service;

import com.api.controlebiblioteca.entity.Emprestimo;
import com.api.controlebiblioteca.repository.EmprestimoRepository;
import com.api.controlebiblioteca.service.EmprestimoService;
import com.api.controlebiblioteca.service.LivroService;
import com.api.controlebiblioteca.service.PessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmprestimoServiceTest {

    @InjectMocks
    EmprestimoService emprestimoService;
    @Mock
    PessoaService pessoaService;
    @Mock
    LivroService livroService;
    @Mock
    EmprestimoRepository emprestimoRepository;

   Emprestimo emprestimo;

    @BeforeEach
    void setUp() {

    }

}
