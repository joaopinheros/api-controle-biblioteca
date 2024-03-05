package com.api.controlebiblioteca.controller;

import com.api.controlebiblioteca.entity.Livro;
import com.api.controlebiblioteca.entity.Pessoa;
import com.api.controlebiblioteca.entity.Situacao;
import com.api.controlebiblioteca.repository.LivroRepository;
import com.api.controlebiblioteca.requestdto.LivroRequestDTO;
import com.api.controlebiblioteca.responsedto.LivroResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livro")

public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public List<LivroResponseDTO> listarLivro(){
        return livroRepository.findAll()
                .stream()
                .map(LivroResponseDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivroPorID(@PathVariable Long id){
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if (livroOptional.isPresent()){
            return ResponseEntity.ok(livroOptional.get());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody LivroRequestDTO data){
        Livro criarLivro = new Livro(data);
        Livro salvarLivro = livroRepository.save(criarLivro);
        return ResponseEntity.ok(salvarLivro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id){
        Optional<Livro> livroOptional = livroRepository.findById(id);

        if (livroOptional.isPresent()){
            livroRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Livro> alterarLivro(@PathVariable Long id, @RequestBody LivroRequestDTO data){
        Optional<Livro> livroOptional = livroRepository.findById(id);

        if (livroOptional.isPresent()){
            Livro livroSalvo = livroOptional.get();
            BeanUtils.copyProperties(data, livroSalvo, "id");
            return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
