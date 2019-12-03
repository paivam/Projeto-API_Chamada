package br.com.chamada.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.chamada.model.Aluno;
import br.com.chamada.model.Turma;
import br.com.chamada.service.AlunoService;
import br.com.chamada.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.chamada.controller.mapping.IController;
import br.com.chamada.model.Chamada;
import br.com.chamada.service.ChamadaService;

@RestController
@RequestMapping(IController.CONTEXTO_CHAMADA)
public class ChamadaController {
	
	@Autowired
	private ChamadaService service;
    @Autowired
    private TurmaService turmaService;
    @Autowired
    private AlunoService alunoService;

	@PostMapping
	public ResponseEntity<Long> cadastrar(@RequestBody Chamada Chamada){
        Chamada ChamadaCadastrada = service.post(Chamada);

        return new ResponseEntity<>(ChamadaCadastrada.getId(), HttpStatus.CREATED);
    }

    @GetMapping(IController.PATH_ID)
    public ResponseEntity<Chamada> buscarPorId(@PathVariable Long id) {
        Chamada Chamada = service.getId(id);

        return new ResponseEntity<>(Chamada, HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<Chamada>> buscar() throws ClassNotFoundException {
        List<Chamada> Chamada = service.get();

        return new ResponseEntity<>(Chamada, HttpStatus.OK);
    }

    @GetMapping("/data")
    public ResponseEntity<List<Chamada>> buscarPorData(@RequestParam("data") String data) throws ParseException {
        List<Chamada> chamadas = service.get(new SimpleDateFormat().parse(data));

	    return new ResponseEntity<>(chamadas, HttpStatus.OK);
    }

    @GetMapping("/presentes/{id}")
    public ResponseEntity<List<Aluno>> buscarAlunosPresentes(@PathVariable("id") Long id) throws ParseException {
        List<Aluno> alunoRet = new ArrayList<>();
        Chamada chamada = service.getId(id);

        Turma turma = chamada.getTurma();

        List<Aluno> alunos = alunoService.getByTurma(turma.getId());

        List<String> alunosFaltaram = Arrays.asList(chamada.getIdAlunosFalta().split(";"));

        for(Aluno aluno : alunos){
            boolean alunoFaltou = false;
            
            for(String idAlunoFaltou : alunosFaltaram){
                if(!idAlunoFaltou.equals(";") || !idAlunoFaltou.equals("")){
                    if(aluno.getId() == Long.parseLong(idAlunoFaltou)){
                        alunoFaltou = true;
                        break;
                    }
                }
            }

            if(!alunoFaltou){
                alunoRet.add(aluno);
            }
        }

        return new ResponseEntity<List<Aluno>>(alunoRet, HttpStatus.OK);
    }

    @PatchMapping(IController.ID)
    public ResponseEntity<Chamada> alterar(@PathVariable Long id, @RequestBody Chamada Chamada) throws ClassNotFoundException {
        Chamada ChamadaNova = service.atualizar(id, Chamada);

        return new ResponseEntity<Chamada>(ChamadaNova, HttpStatus.OK);
    }
	
}
