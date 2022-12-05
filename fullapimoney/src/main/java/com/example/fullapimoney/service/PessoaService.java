package com.example.fullapimoney.service;


import com.example.fullapimoney.entity.Pessoa;
import com.example.fullapimoney.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    public PessoaRepository pessoaRepository;

    public List<Pessoa> listar(){
        return pessoaRepository.findAll();
    }
    public Pessoa buscarUm(Long id){
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.orElse(null);
    }
    public Pessoa criar(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public void deletarPessoa(Long id){
        pessoaRepository.deleteById(id);
    }

}
