package com.api.controlebiblioteca.service;

import com.api.controlebiblioteca.entity.Endereco;
import com.api.controlebiblioteca.entity.Pessoa;
import com.api.controlebiblioteca.exceptionhandler.PessoaNaoCadastradaException;
import com.api.controlebiblioteca.repository.PessoaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

    @InjectMocks
    private PessoaService pessoaService;
    @Mock
    private PessoaRepository pessoaRepository;

    @Test
    @DisplayName("Salvar quando ja existir pessoa cadastrada")
    public void testJaExistePessoaCadastrada(){

        Endereco endereco = new Endereco();
        endereco.setRua("Rua das Flores");
        endereco.setNumero("123");
        endereco.setComplemento("Casa 1");
        endereco.setBairro("Centro");
        endereco.setCep("12345-678");
        endereco.setCidade("São Paulo");
        endereco.setEstado("SP");

        var pessoa = new Pessoa();
        UUID id = UUID.randomUUID();
        pessoa.setId(id);
        pessoa.setNome("Joao");
        pessoa.setCpf("13879854566");
        pessoa.setEmail("joao@example.com");
        pessoa.setTelefone("(11) 91234-5678");
        pessoa.setEndereco(endereco);

        Mockito.when(pessoaRepository.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(PessoaNaoCadastradaException.class, () ->
                pessoaService.verificarPessoaCadastrada(id));

    }
}