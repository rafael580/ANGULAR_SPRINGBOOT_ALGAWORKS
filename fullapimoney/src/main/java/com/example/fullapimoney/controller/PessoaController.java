package com.example.fullapimoney.controller;

import com.example.fullapimoney.entity.Pessoa;
import com.example.fullapimoney.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> listar(){
        return ResponseEntity.ok().body(pessoaService.listar());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Pessoa> buscarPeloCodigo( @PathVariable Long id){
        Pessoa pessoa =  pessoaService.buscarUm(id);
        if (pessoa==null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pessoa);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa){
        pessoa = pessoaService.criar(pessoa);
        URI uri  =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        pessoaService.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoaCompleta(@PathVariable Long id,@Valid @RequestBody Pessoa pessoa){
        return ResponseEntity.ok().body(pessoaService.autualizarPessoa(id,pessoa));
    }
    @PutMapping("/{id}/ativo")
    public ResponseEntity<Void> atualizarPessoaAtivo(@PathVariable Long id,@RequestBody Boolean ativo){
        pessoaService.atualizarAtivo(id,ativo);
        return ResponseEntity.accepted().build();
    }
}
