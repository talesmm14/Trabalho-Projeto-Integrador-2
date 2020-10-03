package com.unitins.projeto2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unitins.projeto2.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	Funcionario findById(long id);
	
}
