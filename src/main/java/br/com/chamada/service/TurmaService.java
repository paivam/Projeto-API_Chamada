package br.com.chamada.service;

import br.com.chamada.model.Aluno;
import br.com.chamada.model.Professor;
import br.com.chamada.model.Turma;
import br.com.chamada.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public Turma cadastrar(Turma turma){
        return turmaRepository.save(turma);
    }

    public Turma buscar(Long id) throws ClassNotFoundException{
        return turmaRepository.findById(id).orElseThrow(ClassNotFoundException::new);
    }

    public Turma atualizar(Long id, Turma turmaNovo) throws ClassNotFoundException{
        Turma turmaAtual = buscar(id);

        List<Professor> professores = GetProfessoresNotInTurma(turmaAtual, turmaNovo);

        List<Aluno> alunos = GetAlunosNotInTurma(turmaAtual, turmaNovo);

        if(!alunos.isEmpty()){
            turmaAtual.getAlunos().addAll(alunos);
        }

        if(!professores.isEmpty()){
            turmaAtual.getProfessores().addAll(professores);
        }

        return cadastrar(turmaAtual);
    }

    private List<Aluno> GetAlunosNotInTurma(Turma turmaAtual, Turma turmaNovo){
        return turmaNovo.getAlunos()
                .stream()
                .filter(a -> !turmaAtual.getAlunos().contains(a))
                .collect(Collectors.toList());
    }

    private List<Professor> GetProfessoresNotInTurma(Turma turmaAtual, Turma turmaNovo){
        return turmaNovo.getProfessores()
                .stream()
                .filter(p -> !turmaAtual.getProfessores().contains(p))
                .collect(Collectors.toList());
    }
}
