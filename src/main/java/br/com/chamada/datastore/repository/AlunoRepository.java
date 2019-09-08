package br.com.chamada.datastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chamada.model.Aluno;

public interface AlunoRepository extends JpaRepository<Long, Aluno> {

}
