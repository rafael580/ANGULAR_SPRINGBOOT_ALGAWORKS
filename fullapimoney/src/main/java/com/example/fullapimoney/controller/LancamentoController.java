package com.example.fullapimoney.controller;

import com.example.fullapimoney.entity.Lancamento;
import com.example.fullapimoney.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @GetMapping
    public ResponseEntity<List<Lancamento>> todosLancamentos(){
        return ResponseEntity.ok().body(lancamentoService.buscarLancamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> pegarUmLancamento(@PathVariable Long id){
        return ResponseEntity.ok().body(lancamentoService.buscarUmLancamento(id));
    }

}
