package com.example.fullapimoney.entity;

import com.example.fullapimoney.entity.enums.TipoLancamento;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {

  final private static Long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String descricao;
    @NotNull
    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;
    @NotNull
    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;
    @NotNull
    private BigDecimal valor;
    @NotNull
    private String obervacao;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoLancamento tipoLancamento;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "categoria_codigo")
    private Categoria categoria;
    @NotNull
    @ManyToOne
    private Pessoa pessoa;


    public Lancamento(){}

    public Lancamento(Long id, String descricao,
                      LocalDate dataVencimento,
                      LocalDate dataPagamento,
                      BigDecimal valor,
                      String obervacao,
                      TipoLancamento tipoLancamento,
                      Categoria categoria,
                      Pessoa pessoa) {
        this.id = id;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.valor = valor;
        this.obervacao = obervacao;
        this.tipoLancamento = tipoLancamento;
        this.categoria = categoria;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getObervacao() {
        return obervacao;
    }

    public void setObervacao(String obervacao) {
        this.obervacao = obervacao;
    }

    public TipoLancamento getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(TipoLancamento tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lancamento that = (Lancamento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
