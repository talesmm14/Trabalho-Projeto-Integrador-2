package com.unitins.projeto2.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 5775600215216301704L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCategoria;
	
	@Column(name="nome", nullable = false)
	private String nome;
	
	public Categoria(String nome) {
		super();
		this.nome = nome;
	}

	public Categoria() {
		super();
	}
	
}
