package br.com.chamada.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_TURMA")
public class Turma implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "NOME_TURMA", updatable = true, unique = true)
	String nome;
	
	@Column(name = "ALUNOS", updatable = true)
	@OneToMany
	List<Aluno> alunos;
	
	@Column(name = "PROFESSORES", updatable = true )
	@ManyToMany
	List<Professor> professores;
	
	@Column(name = "TURNO", updatable = false)
	String turno;
}
