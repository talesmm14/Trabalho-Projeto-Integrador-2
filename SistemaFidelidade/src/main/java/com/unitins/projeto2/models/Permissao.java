package com.unitins.projeto2.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Permissao implements Serializable {

	private static final long serialVersionUID = 3226675709104105792L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPermissao;
	private String descricao;

}
