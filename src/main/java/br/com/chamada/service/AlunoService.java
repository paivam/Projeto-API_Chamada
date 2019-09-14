package br.com.chamada.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.chamada.model.Aluno;
import br.com.chamada.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository repository;

	public Aluno cadastra(Aluno model) {
		
		model.setStatus("Ativo");
		
		return repository.save(model);
	}

	public Aluno atualiza(Long id, Aluno model) throws Exception {
		Aluno alunoAtualizado = repository.findById(id).orElse(null);

		if (alunoAtualizado == null) {
			throw new Exception("Aluno não cadastrado em nosso sistema");
		}

		alunoAtualizado.setNome(model.getNome());
		alunoAtualizado.setStatus(model.getStatus());

		return repository.save(alunoAtualizado);
	}

	public Aluno busca(Long id, Aluno model) throws Exception {
		Aluno alunoEncontrado = repository.findById(id).orElse(null);

		if (alunoEncontrado == null) {
			throw new Exception("Aluno não cadastrado em nosso sistema");
		}

		return alunoEncontrado;
	}
	
	public void deleta(Long id, Aluno model) throws Exception {
		
		if(repository.findById(id) == null) {
			throw new Exception("Aluno não cadastrado em nosso sistema");
		}
		repository.delete(model);
		
	}
	
	public List<Aluno> lista(){
		return repository.findAll();
	}
}