package com.example.fullapimoney.controller;

import com.example.fullapimoney.entity.Lancamento;
import com.example.fullapimoney.repository.filter.LancamentoFilter;
import com.example.fullapimoney.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @GetMapping
    public ResponseEntity<List<Lancamento>> todosLancamentos(LancamentoFilter lancamentoFilter){
        return ResponseEntity.ok().body(lancamentoService.buscarLancamentos(lancamentoFilter));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> pegarUmLancamento(@PathVariable Long id){
        return ResponseEntity.ok().body(lancamentoService.buscarUmLancamento(id));
    }
    @PostMapping
    public ResponseEntity<Lancamento> pegarUmLancamento(@Valid @RequestBody Lancamento lancamento){
        lancamento = lancamentoService.criarLancamento(lancamento);
        URI uri  =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(lancamento.getId()).toUri();
        return ResponseEntity.created(uri).body(lancamento);
    }

}
