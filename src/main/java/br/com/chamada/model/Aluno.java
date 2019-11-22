package br.com.chamada.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_ALUNO")
public class Aluno implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@NotNull(message = "o campo não deve ser nulo")
	@Column(name = "NOME_ALUNO", updatable = true)
	String nome;
	
	@Column(name = "MATRICULA", updatable = false, unique = true)
	@NotNull(message = "o campo não deve ser nulo")
	Long matricula;
	
	@Column(name = "STATUS", updatable = true)	
	String status;

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

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

