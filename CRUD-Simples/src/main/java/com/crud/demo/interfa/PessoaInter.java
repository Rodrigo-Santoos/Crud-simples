package com.crud.demo.interfa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.model.Pessoa;

public interface PessoaInter extends JpaRepository<Pessoa, Integer> {

}
