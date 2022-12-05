package com.example.fullapimoney.repository.lancamento;

import com.example.fullapimoney.entity.Lancamento;
import com.example.fullapimoney.repository.filter.LancamentoFilter;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class LancamentoRepositoryImpl implements LancamentoRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Lancamento> filtar(LancamentoFilter lancamentoFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Lancamento> criteria = builder.createQuery(Lancamento.class);
        Root<Lancamento> root = criteria.from(Lancamento.class);


        //criar restricoes
        Predicate[] predicates = criarRestricoes(lancamentoFilter,builder,root);
        criteria.where(predicates);

        TypedQuery<Lancamento> query = manager.createQuery(criteria);
        return query.getResultList();
    }

    private Predicate[] criarRestricoes(
            LancamentoFilter lancamentoFilter
            ,CriteriaBuilder  builder ,
            Root<Lancamento> root){

        List<Predicate> predicates = new ArrayList<>();

        if(lancamentoFilter.getDescricao()!=null){
            predicates.add(builder.like(
                    builder.lower(root.get("descricao")),
                    "%" +
                            lancamentoFilter.
                            getDescricao().
                            toLowerCase() + "%"
                    ));
        }
        if(lancamentoFilter.getDataVencimento()!=null){
            predicates.add(
                    builder.greaterThanOrEqualTo(root.get("dataVencimento"),
                    lancamentoFilter.getDataVencimento()));
        }
        if(lancamentoFilter.getDataVencimentoAte()!=null){
            predicates.add(
                    builder.lessThanOrEqualTo(root.get("dataVencimentoAte"),lancamentoFilter.getDataVencimentoAte())
            );
        }
        return  predicates.toArray(new Predicate[predicates.size()]);
    }

}
