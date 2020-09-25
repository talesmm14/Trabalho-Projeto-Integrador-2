package com.unitins.projeto2.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Funcionario extends Usuario {

	private static final long serialVersionUID = -2513556090171419870L;
	
	private String senha;
	@ManyToOne
	@JoinColumn(name = "id_permissao")
	private Permissao permissao;
	

}
