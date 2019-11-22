package br.com.chamada.controller;

import java.util.List;

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
