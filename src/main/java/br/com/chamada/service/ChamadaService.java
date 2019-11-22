package br.com.chamada.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.chamada.model.Chamada;
import br.com.chamada.repository.ChamadaRepository;

@Service
public class ChamadaService {

	@Autowired
	private ChamadaRepository repo;
	
	public List<Chamada> get() {
		return repo.findAll();
	}
	
	public Chamada getId(Long id) {
		return repo.findById(id).orElseThrow(null);
	}
	
	public Chamada post(Chamada model) {
		return repo.save(model);
	}
	
}
