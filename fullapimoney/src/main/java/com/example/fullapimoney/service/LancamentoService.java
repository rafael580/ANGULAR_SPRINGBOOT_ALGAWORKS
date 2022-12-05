package com.example.fullapimoney.service;

import com.example.fullapimoney.entity.Lancamento;
import com.example.fullapimoney.entity.Pessoa;
import com.example.fullapimoney.repository.LancamentoRepository;
import com.example.fullapimoney.repository.PessoaRepository;
import com.example.fullapimoney.repository.filter.LancamentoFilter;
import com.example.fullapimoney.service.exception.DataBaseException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService {
    @Autowired
    private LancamentoRepository lancamentoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Lancamento> buscarLancamentos(LancamentoFilter lancamentoFilter){
        return lancamentoRepository.filtar(lancamentoFilter);
    }
    public Lancamento buscarUmLancamento(Long id){
        Optional<Lancamento> lancamento = lancamentoRepository.findById(id);
        Lancamento lancamento1 = lancamento.orElse(null);
        return lancamento1;
    }

    public Lancamento criarLancamento(Lancamento lancamento){
       Optional<Pessoa> pessoa = pessoaRepository.findById(lancamento.getPessoa().getId());
        if (pessoa.orElse(null)==null || !pessoa.orElse(null).getAtivo()){
            throw  new DataBaseException("pessoa nao encontrada");
        }
        return lancamentoRepository.save(lancamento);
    }

}
