package br.com.chamada.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_USUARIO")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "LOGIN", updatable = true, unique = true)
	String login;
	@Column(name = "SENHA", updatable = true)
	String senha;
	@Column(name = "TIPO", updatable = false)
	String tipo;
}
