package com.example.fullapimoney.controller;

import com.example.fullapimoney.entity.Categoria;
import com.example.fullapimoney.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> listar(){
        return ResponseEntity.ok().body(categoriaService.listar());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Categoria> buscarPeloCodigo( @PathVariable Long id){
      Categoria categoria =  categoriaService.buscarUm(id);
      if (categoria==null){
          ResponseEntity.notFound().build();
      }
        return ResponseEntity.ok().body(categoria);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria){
      categoria = categoriaService.criar(categoria);
      URI uri  =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}")
              .buildAndExpand(categoria.getCodigo()).toUri();
      return ResponseEntity.created(uri).body(categoria);
    }

}
