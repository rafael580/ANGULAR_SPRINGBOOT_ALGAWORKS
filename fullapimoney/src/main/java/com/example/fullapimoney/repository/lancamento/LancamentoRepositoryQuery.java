package com.example.fullapimoney.repository.lancamento;

import com.example.fullapimoney.entity.Lancamento;
import com.example.fullapimoney.repository.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LancamentoRepositoryQuery {

    public Page<Lancamento> filtar(LancamentoFilter lancamentoFilter, Pageable pageable);
}
