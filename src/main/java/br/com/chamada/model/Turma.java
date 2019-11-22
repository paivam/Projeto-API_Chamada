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

	@Column(name = "ALUNOS", updatable = true)
	@OneToMany
	List<Aluno> alunos;

	@Column(name = "PROFESSORES", updatable = true)
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
}
