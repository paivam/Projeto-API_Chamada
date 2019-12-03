package br.com.chamada.service;

import br.com.chamada.model.Aluno;
import br.com.chamada.model.Professor;
import br.com.chamada.model.Turma;
import br.com.chamada.model.TurmaAluno;
import br.com.chamada.repository.AlunoRepository;
import br.com.chamada.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public Turma cadastrar(Turma turma) throws ClassNotFoundException {
        Turma turmaAtual = null;
        
        List<Turma> turmas = getTodas();

        for(Turma newTurma : turmas){
            if(turma.getNome().equals(newTurma.getNome())){
                turmaAtual = newTurma;
                break;
            }
        }

        if(turmaAtual == null){
            return turmaRepository.save(turma);
        } else{
            return turmaAtual;
        }
    }

    public List<Turma> getTodas(){
    	return turmaRepository.findAll();
    }

    public Turma buscar(Long id) throws ClassNotFoundException{
        return turmaRepository.findById(id).orElseThrow(ClassNotFoundException::new);
    }

    public Turma atualizar(Long id, Turma turmaNovo) throws ClassNotFoundException{
        Turma turmaAtual = buscar(id);

        List<Professor> professores = GetProfessoresNotInTurma(turmaAtual, turmaNovo);

        if(!professores.isEmpty()){
            turmaAtual.getProfessores().addAll(professores);
        }

        return cadastrar(turmaAtual);
    }
    
    private List<Professor> GetProfessoresNotInTurma(Turma turmaAtual, Turma turmaNovo){
        return turmaNovo.getProfessores()
                .stream()
                .filter(p -> !turmaAtual.getProfessores().contains(p))
                .collect(Collectors.toList());
    }
}
