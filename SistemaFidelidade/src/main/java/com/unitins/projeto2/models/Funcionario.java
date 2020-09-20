package com.unitins.projeto2.models;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Funcionario extends Usuario {

	private static final long serialVersionUID = -2513556090171419870L;
	
	private String senha;
	

}
