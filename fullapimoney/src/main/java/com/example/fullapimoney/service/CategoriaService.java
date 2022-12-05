package com.example.fullapimoney.service;


import com.example.fullapimoney.entity.Categoria;
import com.example.fullapimoney.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listar(){
        return categoriaRepository.findAll();
    }
    public Categoria buscarUm(Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElse(null);
    }
    public Categoria criar(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
}
