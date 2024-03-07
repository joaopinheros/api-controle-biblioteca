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
@RequestMapping("/biblioteca")
public class EmprestimoController {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping("/livros-emprestados")
    public List<EmprestimoResponseDTO> listarLivrosEmprestados(){
        return emprestimoRepository.findAll()
                .stream()
                .map(EmprestimoResponseDTO::new)
                .collect(Collectors.toList());
    }
    @PostMapping("/emprestar-livro")
    public ResponseEntity<Emprestimo> criarEmprestimo(@RequestBody EmprestimoRequestDTO data){
        Emprestimo emprestimoSalvo = emprestimoService.criarEmprestimo(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoSalvo);
    }

    @PostMapping("/devolver-livro")
    public ResponseEntity<Emprestimo> criarDevolucao(@RequestBody EmprestimoRequestDTO data){
        Emprestimo devolucaoSalva = emprestimoService.criarDevolucao(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(devolucaoSalva);
    }

    @PostMapping("/reservar-livro")
    public ResponseEntity<Emprestimo> criarReserva(@RequestBody EmprestimoRequestDTO data){
        Emprestimo reservaSalva = emprestimoService.criarReserva(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaSalva);
    }

}
