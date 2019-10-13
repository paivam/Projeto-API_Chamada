package br.com.chamada.controller;

import br.com.chamada.controller.mapping.IController;
import br.com.chamada.model.Professor;
import br.com.chamada.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IController.CONTEXTO_PROFESSOR)
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    private final static String PATH_ID = "/{id}";
    private final static String ID = "id";

    @GetMapping(PATH_ID)
    public ResponseEntity<Professor> buscar(@PathVariable(ID) Long id) throws ClassNotFoundException {
        Professor professor = professorService.buscar(id);

        return new ResponseEntity<>(professor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Professor> cadastrar(@RequestBody Professor professor){
        Professor novoProfessor = professorService.cadastrar(professor);

        return new ResponseEntity<>(novoProfessor, HttpStatus.CREATED);
    }

    @PatchMapping(PATH_ID)
    public ResponseEntity<Professor> atualizar(@PathVariable(ID) Long id, @RequestBody Professor professor) throws ClassNotFoundException {
        Professor professorAlterado = professorService.atualizar(id, professor);

        return new ResponseEntity<>(professorAlterado, HttpStatus.OK);
    }
}
