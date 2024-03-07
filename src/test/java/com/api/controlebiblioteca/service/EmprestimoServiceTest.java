package com.api.controlebiblioteca.service;

import com.api.controlebiblioteca.entity.Emprestimo;
import com.api.controlebiblioteca.repository.EmprestimoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmprestimoServiceTest {

    @InjectMocks
    EmprestimoService emprestimoService;
    @Mock
    EmprestimoRepository emprestimoRepository;

    Emprestimo emprestimo;
    @Test
    void criarEmprestimoComSucesso() {
    }

    @Test
    void criarDevolucaoComSucesso() {
    }

    @Test
    void criarReservaComSucesso() {
    }
}