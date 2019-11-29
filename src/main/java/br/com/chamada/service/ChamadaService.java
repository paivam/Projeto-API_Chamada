package br.com.chamada.service;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.chamada.model.Aluno;
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

	public List<Chamada> get(Date data){
		return repo.findAllByData(data);
	}

	public Chamada atualizar(Long id, Chamada chamadaNova){
		Chamada chamadaAtual = getId(id);

		List<Aluno> alunos = GetAlunosNotInAtual(chamadaAtual, chamadaNova);
		List<String> alunosFaltou = GetAlunosFaltouNotInAtual(chamadaAtual, chamadaNova);

		if(!alunos.isEmpty()){
			chamadaAtual.setAlunos(alunos);
		}

		if(!alunosFaltou.isEmpty()){
			alunosFaltou.forEach(a -> chamadaAtual.setIdAlunosFalta(a + ";"));
		}

		return post(chamadaAtual);
	}

	private List<Aluno> GetAlunosNotInAtual(Chamada chamadaAtual, Chamada chamadaNova){
		return chamadaNova.getAlunos()
				.stream()
				.filter(aluno -> !chamadaAtual.getAlunos().contains(aluno))
				.collect(Collectors.toList());
	}

	private List<String> GetAlunosFaltouNotInAtual(Chamada chamadaAtual, Chamada chamadaNova){
		return Arrays.asList(chamadaAtual.getIdAlunosFalta().split(";"))
				.stream()
				.filter(aluno -> !Arrays.asList(chamadaNova.getIdAlunosFalta().split(";")).contains(aluno))
				.collect(Collectors.toList());
	}
}
