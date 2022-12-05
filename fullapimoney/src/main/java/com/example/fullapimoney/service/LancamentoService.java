package com.example.fullapimoney.service;

import com.example.fullapimoney.entity.Lancamento;
import com.example.fullapimoney.repository.LancamentoRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService {
    @Autowired
    private LancamentoRepository lancamentoRepository;


    public List<Lancamento> buscarLancamentos(){
        return lancamentoRepository.findAll();
    }
    public Lancamento buscarUmLancamento(Long id){
        Optional<Lancamento> lancamento = lancamentoRepository.findById(id);
        Lancamento lancamento1 = lancamento.orElse(null);
        return lancamento1;
    }

}
