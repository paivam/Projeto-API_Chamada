package br.com.chamada.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.chamada.model.Professor;
import br.com.chamada.repository.ProfessorRepository;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public Professor cadastrar(Professor professor){
        return professorRepository.save(professor);
    }

    public Professor buscar(Long id) throws ClassNotFoundException{
        return professorRepository.findById(id).orElseThrow(ClassNotFoundException::new);
    }

    public Professor atualizar(Long id, Professor professorNovo) throws ClassNotFoundException{
        Professor professorAtual = buscar(id);

        professorAtual.setNome(professorNovo.getNome());

        return cadastrar(professorAtual);
    }
}
