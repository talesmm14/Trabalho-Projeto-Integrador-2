package com.unitins.projeto2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unitins.projeto2.models.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Long>{

	Cliente findById(long id);

	Cliente findByCpf(String cpf);
	
}
