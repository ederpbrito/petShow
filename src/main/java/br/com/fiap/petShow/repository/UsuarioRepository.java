package br.com.fiap.petShow.repository;

import br.com.fiap.petShow.user.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findByLogin(String login);
}
