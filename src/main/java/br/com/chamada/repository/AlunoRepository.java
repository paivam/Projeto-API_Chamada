package br.com.chamada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.chamada.model.Aluno;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
