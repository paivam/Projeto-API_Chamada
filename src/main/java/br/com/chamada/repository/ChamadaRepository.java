package br.com.chamada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.chamada.model.Chamada;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ChamadaRepository extends JpaRepository<Chamada, Long> {
    List<Chamada> findAllByData(Date data);
}
