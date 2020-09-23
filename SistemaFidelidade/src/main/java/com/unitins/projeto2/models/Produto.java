package com.unitins.projeto2.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 49212977968023201L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProduto;
	private String nome;
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	private Integer pontosRecebidos;
	private Integer pontosRetirada;

}
