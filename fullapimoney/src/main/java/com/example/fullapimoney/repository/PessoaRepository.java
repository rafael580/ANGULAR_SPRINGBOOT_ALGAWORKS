package com.example.fullapimoney.repository;

import com.example.fullapimoney.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository  extends JpaRepository<Pessoa,Long> {
}
