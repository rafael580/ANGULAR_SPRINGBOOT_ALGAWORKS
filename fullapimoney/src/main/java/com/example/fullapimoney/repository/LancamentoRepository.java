package com.example.fullapimoney.repository;

import com.example.fullapimoney.entity.Lancamento;
import com.example.fullapimoney.repository.lancamento.LancamentoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento,Long> , LancamentoRepositoryQuery {



}
