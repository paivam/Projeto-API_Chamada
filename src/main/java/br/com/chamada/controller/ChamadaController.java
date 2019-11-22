package br.com.chamada.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chamada.controller.mapping.IController;
import br.com.chamada.model.Chamada;
import br.com.chamada.service.ChamadaService;

@RestController
@RequestMapping(IController.CONTEXTO_CHAMADA)
public class ChamadaController {
	
	@Autowired
	private ChamadaService service;

	@PostMapping
	public ResponseEntity<Chamada> cadastrar(@RequestBody Chamada Chamada){
        Chamada ChamadaCadastrada = service.post(Chamada);

        return new ResponseEntity<>(ChamadaCadastrada, HttpStatus.CREATED);
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

//    @PatchMapping(IController.ID)
//    public ResponseEntity<Chamada> alterar(@PathVariable Long id, @RequestBody Chamada Chamada) throws ClassNotFoundException {
//        Chamada ChamadaNova = ChamadaService.atualizar(id, Chamada);
//
//        return new ResponseEntity<Chamada>(ChamadaNova, HttpStatus.OK);
//    }
	
}
