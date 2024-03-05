package com.api.controlebiblioteca.controller;

import com.api.controlebiblioteca.entity.Pessoa;
import com.api.controlebiblioteca.repository.PessoaRepository;
import com.api.controlebiblioteca.requestdto.PessoaRequestDTO;
import com.api.controlebiblioteca.responsedto.PessoaResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")

public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<PessoaResponseDTO> listarPessoa(){
        return pessoaRepository.findAll()
                .stream()
                .map(PessoaResponseDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoaPorID(@PathVariable UUID id){
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);

        if (pessoaOptional.isPresent()){
            return ResponseEntity.ok(pessoaOptional.get());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody PessoaRequestDTO data){
        Pessoa criarPessoa = new Pessoa(data);
        Pessoa pessoaSalva = pessoaRepository.save(criarPessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable UUID id){
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);

//        if(pessoaOptional == null){
//            throw new ...
//        }

        if (pessoaOptional.isPresent()){
            pessoaRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Pessoa> alterarPessoa(@PathVariable UUID id,
                                                 @RequestBody PessoaRequestDTO data){
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);

        if (pessoaOptional.isPresent()){
            Pessoa pessoaSalva = pessoaOptional.get();
            BeanUtils.copyProperties(data, pessoaSalva, "id");
            pessoaRepository.save(pessoaSalva);
            return ResponseEntity.ok(pessoaSalva);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
