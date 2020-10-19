package com.unitins.projeto2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Funcionario extends Usuario {

	private static final long serialVersionUID = -2513556090171419870L;
	
	@Column(name="senha", nullable = false)
	private String senha;
	@ManyToOne
	@JoinColumn(name = "id_permissao")
	private Permissao permissao;
	
	public Funcionario() {}

	public Funcionario(String nome, String cpf, String email, String senha, Permissao permissao) {
		super(nome, cpf, email);
		this.senha = senha;
		this.permissao = permissao;
	}

}
