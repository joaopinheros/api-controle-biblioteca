package com.api.controlebiblioteca.controller;

import com.api.controlebiblioteca.entity.Emprestimo;
import com.api.controlebiblioteca.repository.EmprestimoRepository;
import com.api.controlebiblioteca.requestdto.EmprestimoRequestDTO;
import com.api.controlebiblioteca.responsedto.EmprestimoResponseDTO;
import com.api.controlebiblioteca.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public List<EmprestimoResponseDTO> listarLivrosEmprestados(){
        return emprestimoRepository.findAll()
                .stream()
                .map(EmprestimoResponseDTO::new)
                .collect(Collectors.toList());
    }
    @PostMapping
    public ResponseEntity<Emprestimo> criarEmprestimo(@RequestBody EmprestimoRequestDTO data){
        Emprestimo emprestimoSalvo = emprestimoService.criarEmprestimo(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoSalvo);
    }

}
