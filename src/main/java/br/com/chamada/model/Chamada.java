package br.com.chamada.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_CHAMADA")
public class Chamada implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false)
	Long id;
	
	@JsonFormat(pattern =  "dd-mm-yyyy")
	@Column(name = "DATA", updatable = false)
	Date data;
	
	@ManyToMany
	@JoinColumn(name =  "professores")
	List<Professor> professores;

	@ManyToMany
	@JoinColumn(name =  "alunos")
	List<Aluno> alunos;

	String idAlunosFalta;

	Long idTurma;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String getIdAlunosFalta() {
		return idAlunosFalta;
	}

	public void setIdAlunosFalta(String idAlunosFalta) {
		this.idAlunosFalta = idAlunosFalta;
	}
}
