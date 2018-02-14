package br.com.fiap.petShow.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioComponent usuarioComponent;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsuarioController(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody Usuario user) {
        user.setSenha(bCryptPasswordEncoder.encode(user.getSenha()));
        usuarioComponent.salvar(user);
    }
}
