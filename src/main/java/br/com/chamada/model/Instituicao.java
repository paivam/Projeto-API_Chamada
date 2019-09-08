package br.com.chamada.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_INSTITUICAO")
public class Instituicao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "NOME_INSTUICAO", updatable = true)
	String nome;
	
	@Column(name = "TURMA", updatable = true)
	@OneToMany
	List<Turma> turmas;
	
	@Column(name = "USUARIO", updatable = true, unique = true)
	@OneToOne
	Usuario usuario;
}
