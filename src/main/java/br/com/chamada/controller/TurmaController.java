package br.com.chamada.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.chamada.model.Aluno;
import br.com.chamada.model.TurmaAluno;
import br.com.chamada.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chamada.controller.mapping.IController;
import br.com.chamada.model.Turma;
import br.com.chamada.service.TurmaService;

@RestController
@RequestMapping(IController.CONTEXTO_TURMA)
public class TurmaController {

    @Autowired
    private TurmaService turmaService;
    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Turma> cadastrar(@RequestBody TurmaAluno turmaAluno) throws Exception {
        List<Aluno> alunos = new ArrayList<>();
        
        Turma turmaCadastrada = turmaService.cadastrar(turmaAluno.getTurma());

        for(Aluno aluno : turmaAluno.getAlunos()){
            Aluno alunoToAdd = alunoService.busca(aluno.getId());
            
            if(alunoToAdd != null){
                alunos.add(alunoToAdd);
            }
        }

        for(Aluno aluno : alunos){
            aluno.setTurma(turmaCadastrada);

            alunoService.cadastra(aluno);
        }

        return new ResponseEntity<Turma>(turmaCadastrada, HttpStatus.CREATED);
    }

    @GetMapping(IController.PATH_ID)
    public ResponseEntity<Turma> buscar(@PathVariable Long id) throws ClassNotFoundException {
        Turma turma = turmaService.buscar(id);

        return new ResponseEntity<Turma>(turma, HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<Turma>> buscarTodas() throws ClassNotFoundException {
        List<Turma> turma = turmaService.getTodas();

        return new ResponseEntity<>(turma, HttpStatus.OK);
    }

    @PatchMapping(IController.ID)
    public ResponseEntity<Turma> alterar(@PathVariable Long id, @RequestBody Turma turma) throws ClassNotFoundException {
        Turma turmaNova = turmaService.atualizar(id, turma);

        return new ResponseEntity<Turma>(turmaNova, HttpStatus.OK);
    }
}
