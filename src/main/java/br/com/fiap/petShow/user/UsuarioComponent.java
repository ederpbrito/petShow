package br.com.fiap.petShow.user;

import br.com.fiap.petShow.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioComponent {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean autenticarLogin(String login, String senha){
        Usuario usuario = usuarioRepository.findByLogin(login);
        boolean autenticado = false;

        if(usuario == null){
            autenticado = false;
        }else if(usuario.getLogin().equals(login) && usuario.getLogin().equals(senha)){
            autenticado = true;
        }

        return autenticado;
    }

    public void salvar(Usuario user) {
        Usuario usuario = usuarioRepository.findByLogin(user.getLogin());

        if(usuario != null){
            throw new RuntimeException("Usuário já existente!");
        }

        usuarioRepository.save(user);
    }
}
