package com.unitins.projeto2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unitins.projeto2.models.Promocao;

public interface PromocaoRepository  extends JpaRepository<Promocao, Long>{

	Promocao findById(long id);

	Promocao findByNome(String nome);
	
}
