package com.unitins.projeto2.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class Usuario implements Serializable {

	private static final long serialVersionUID = -4331797435789532344L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idUsuario;
	private String nome;
	private String cpf;
	private String email;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracao;
	
	@PreUpdate
	private void atualizarUsuario() {
		dataAlteracao= new Date();
	}
	
	
	
}
