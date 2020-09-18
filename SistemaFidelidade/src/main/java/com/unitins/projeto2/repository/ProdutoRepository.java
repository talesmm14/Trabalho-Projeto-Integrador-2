package com.unitins.projeto2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unitins.projeto2.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	Produto findById(long id);
	
}
