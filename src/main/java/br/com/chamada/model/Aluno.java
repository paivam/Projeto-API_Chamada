package br.com.chamada.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_ALUNO")
public class Aluno implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "NOME_ALUNO", updatable = true)
	String nome;
	
	@Column(name = "MATRICULA", updatable = false, unique = true)
	Long matricula;
}
