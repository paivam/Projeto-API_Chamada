package br.com.chamada.controller;

import br.com.chamada.controller.mapping.IController;
import br.com.chamada.model.Aluno;
import br.com.chamada.model.Turma;
import br.com.chamada.service.AlunoService;
import br.com.chamada.service.ProfessorService;
import br.com.chamada.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IController.CONTEXTO_TURMA)
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public ResponseEntity<Turma> cadastrar(@RequestBody Turma turma){
        Turma turmaCadastrada = turmaService.cadastrar(turma);

        return new ResponseEntity<Turma>(turmaCadastrada, HttpStatus.CREATED);
    }

    @GetMapping(IController.PATH_ID)
    public ResponseEntity<Turma> buscar(@PathVariable Long id) throws ClassNotFoundException {
        Turma turma = turmaService.buscar(id);

        return new ResponseEntity<Turma>(turma, HttpStatus.OK);
    }

    @PatchMapping(IController.ID)
    public ResponseEntity<Turma> alterar(@PathVariable Long id, @RequestBody Turma turma) throws ClassNotFoundException {
        Turma turmaNova = turmaService.atualizar(id, turma);

        return new ResponseEntity<Turma>(turmaNova, HttpStatus.OK);
    }
}
