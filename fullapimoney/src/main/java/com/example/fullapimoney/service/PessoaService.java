package com.example.fullapimoney.service;


import com.example.fullapimoney.entity.Pessoa;
import com.example.fullapimoney.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
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
    public Pessoa autualizarPessoa(Long id,Pessoa pessoa){
            Optional<Pessoa> p  = pessoaRepository.findById(id);
            Pessoa pessoa1 =  p.orElse(null);
            BeanUtils.copyProperties(pessoa,pessoa1);
            return      pessoaRepository.save(pessoa1);
    }
    public void atualizarAtivo(Long id,Boolean ativo){
        Optional<Pessoa> p  = pessoaRepository.findById(id);
        Pessoa pessoa1 =  p.orElse(null);
        pessoa1.setAtivo(ativo);
        pessoaRepository.save(pessoa1);
    }
}
