package com.example.fullapimoney.repository.lancamento;

import com.example.fullapimoney.entity.Lancamento;
import com.example.fullapimoney.repository.filter.LancamentoFilter;

import java.util.List;

public interface LancamentoRepositoryQuery {

    public List<Lancamento> filtar(LancamentoFilter lancamentoFilter);
}
