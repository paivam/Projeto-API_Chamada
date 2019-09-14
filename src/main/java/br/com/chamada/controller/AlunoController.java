package br.com.chamada.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chamada.controller.mapping.Icontroller;
import br.com.chamada.model.Aluno;
import br.com.chamada.service.AlunoService;

@RestController
@RequestMapping(Icontroller.CONTEXTO_ALUNO)
public class AlunoController {

	public final static String PATH_ID = "/{aluno_id}";
	public final static String ID = "id";

	@Autowired
	AlunoService service;

	@PostMapping
	public ResponseEntity<List<Aluno>> cadastraAluno(@RequestBody List<Aluno> request) {

		List<Aluno> alunosCadastrados = new ArrayList<>();

		for (Aluno model : request) {

			Aluno aluno = service.cadastra(model);

			alunosCadastrados.add(aluno);

		}
		return new ResponseEntity<>(alunosCadastrados, HttpStatus.CREATED);
	}

	@PatchMapping(PATH_ID)
	public ResponseEntity<Aluno> atualizaAluno(@PathVariable(value = ID) Long id, @RequestBody Aluno model)
			throws Exception {
		
		Aluno alunoAtualizado = service.atualiza(id, model);

		return new ResponseEntity<Aluno>(alunoAtualizado, HttpStatus.OK);

	}
	
	@GetMapping(PATH_ID)
	public ResponseEntity<Aluno> buscaAluno(@PathVariable(value = ID) Long id, @RequestBody Aluno model) throws Exception{
		
		Aluno alunoEncontrado = service.busca(id, model);
		
		return new ResponseEntity<Aluno>(alunoEncontrado, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Aluno>> listaAluno(){
		List<Aluno> alunosEncontrados = service.lista();
		
		if(alunosEncontrados.isEmpty()) {
			return new ResponseEntity<List<Aluno>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Aluno>>(alunosEncontrados, HttpStatus.OK);
	}
	

	@DeleteMapping(PATH_ID)
	public ResponseEntity<String> deletaAluno(@PathVariable(value = ID) Long id, @RequestBody Aluno model) throws Exception{
		service.deleta(id, model);
		
		return new ResponseEntity<String>("Aluno deletado com sucesso", HttpStatus.OK);
	}
}
