package br.com.chamada.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

    @PatchMapping(IController.ID)
    public ResponseEntity<Chamada> alterar(@PathVariable Long id, @RequestBody Chamada Chamada) throws ClassNotFoundException {
        Chamada ChamadaNova = service.atualizar(id, Chamada);

        return new ResponseEntity<Chamada>(ChamadaNova, HttpStatus.OK);
    }
	
}
