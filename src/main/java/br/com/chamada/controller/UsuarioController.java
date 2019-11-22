package br.com.chamada.controller;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.chamada.controller.mapping.IController;
import br.com.chamada.model.Usuario;
import br.com.chamada.service.UsuarioService;


@RestController
@RequestMapping(IController.CONTEXTO_USUARIO)
public class UsuarioController {

    private final static String PATH_ID = "/{id}";
    private final static String ID = "id";
    private final static String LOGIN = "login";
    private final static String SENHA = "senha";

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity efetuarLogin(@RequestParam(LOGIN) String login, @RequestParam(SENHA) String senha) throws AttributeNotFoundException {
        Usuario usuario = usuarioService.login(login, senha);

        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioCadastrado = usuarioService.salvar(usuario);

        return new ResponseEntity<>(usuarioCadastrado, HttpStatus.CREATED);
    }

    @PatchMapping(PATH_ID)
    public ResponseEntity<Usuario> alterarUsuario(@PathVariable(ID) Long id, @RequestBody Usuario usuario) throws AttributeNotFoundException {
        Usuario usuarioAlterado = usuarioService.alterar(id, usuario);

        return new ResponseEntity<>(usuarioAlterado, HttpStatus.OK);
    }

    @GetMapping(PATH_ID)
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable(ID) Long id) throws AttributeNotFoundException {
        Usuario usuario = usuarioService.buscar(id);

        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
}
