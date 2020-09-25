package com.unitins.projeto2.models;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class HistoricoTroca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idHistoricoTroca;
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataOperacao;
	
	@PrePersist
	public void dataOperacao() {
		dataOperacao = new Date();
	}

}
