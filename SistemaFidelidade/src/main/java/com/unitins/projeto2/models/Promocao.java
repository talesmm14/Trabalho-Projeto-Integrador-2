package com.unitins.projeto2.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Promocao {

	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "foto", nullable = false)
	private String foto;

	public Promocao() {
	}

	public Promocao(String nome, String foto) {
		super();
		this.nome = nome;
		this.foto = foto;
	}

}
