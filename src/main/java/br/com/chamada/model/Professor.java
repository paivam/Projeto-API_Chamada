package br.com.chamada.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "tb_PROFESSOR")
public class Professor implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME_PROFESSOR", updatable = true)
    private String nome;

    @Column(name = "MATRICULA", updatable = false, unique = true)
    private Long matricula;
    
//	@Column(name = "USUARIO", updatable = true, unique = true)
//	@OneToOne
//	Usuario usuario;


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
}
