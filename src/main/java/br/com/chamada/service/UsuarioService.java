package br.com.chamada.service;

import br.com.chamada.model.Usuario;
import br.com.chamada.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.AttributeNotFoundException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario login(String login, String senha) throws AttributeNotFoundException {
        return usuarioRepository.findByLoginAndSenha(login, senha).orElseThrow(AttributeNotFoundException::new);
    }

    public Usuario alterar(Long id, Usuario usuarioNovo) throws AttributeNotFoundException {
        Usuario usuario =  buscar(id);

        usuario.setLogin(usuarioNovo.getLogin());
        usuario.setSenha(usuarioNovo.getSenha());

        return salvar(usuario);
    }

    public Usuario buscar(Long id) throws AttributeNotFoundException {
        return usuarioRepository.findById(id).orElseThrow(AttributeNotFoundException::new);
    }

    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
