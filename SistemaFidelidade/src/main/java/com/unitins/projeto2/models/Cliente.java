package com.unitins.projeto2.models;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Cliente extends Usuario {

	private static final long serialVersionUID = -3109859511744004660L;

	private String telefone;
	private Integer pontos;
	

}
