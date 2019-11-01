package br.com.chamada.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_USUARIO")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(name = "LOGIN", updatable = true, unique = true)
	String login;
	@Column(name = "SENHA", updatable = true)
	String senha;
	@Column(name = "TIPO", updatable = false)
	String tipo;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		if(!login.isEmpty()){
			this.login = login;
		}
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if(!senha.isEmpty()){
			this.senha = senha;
		}
	}
}
