package br.com.fiap.petShow.security;

import br.com.fiap.petShow.Users.Usuario;
import org.springframework.security.core.userdetails.User;
import br.com.fiap.petShow.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(login);
        if (usuario == null) {
            throw new UsernameNotFoundException(login);
        }
        return new User(usuario.getLogin(), usuario.getSenha(), emptyList());
    }
}
