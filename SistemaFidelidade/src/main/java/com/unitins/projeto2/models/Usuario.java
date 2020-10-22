package com.unitins.projeto2.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
public abstract class Usuario implements Serializable {

	private static final long serialVersionUID = -4331797435789532344L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;
	@Column(name="nome", nullable = false)
	private String nome;
	@Column(name="cpf", nullable = false)
	private String cpf;
	@Column(name="email", nullable = false)
	private String email;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracao;
	private boolean status;
	
	@PreUpdate
	private void atualizarUsuario() {
		dataAlteracao= new Date();
	}
	
	protected Usuario() {
		this.status = true;
	}
	
	protected Usuario(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.status = true;
	}
	
}
