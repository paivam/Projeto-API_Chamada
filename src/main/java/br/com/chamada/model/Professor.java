//package br.com.chamada.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import lombok.Data;
//
//@Data
//@Entity
//@Table(name = "tb_PROFESSOR")
//public class Professor implements Serializable{
//
//	private static final long serialVersionUID = 1L;
//
//	@Column(name = "NOME_PROFESSOR", updatable = true)
//	String nome;
//	
//	@Column(name = "MATRICULA", updatable = false, unique = true)
//	Long matricula;
//	
//	@Column(name = "USUARIO", updatable = true, unique = true)
//	@OneToOne
//	Usuario usuario;
//}
