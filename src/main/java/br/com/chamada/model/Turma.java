package br.com.chamada.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_TURMA")
public class Turma implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

	@Column(name = "NOME_TURMA", updatable = true, unique = true)
	String nome;

	@JoinColumn(name = "TURMA", updatable = true)
	@OneToMany
	List<Aluno> alunos;

	@JoinColumn(name = "PROFESSORES", updatable = true)
	@ManyToMany
	List<Professor> professores;

	@Column(name = "TURNO", updatable = false)
	String turno;

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
}
