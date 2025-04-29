package br.edu.senaisp.colegio.controller;

import br.edu.senaisp.colegio.model.dto.UsuarioEntradaDTO;
import br.edu.senaisp.colegio.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public String login(@RequestBody UsuarioEntradaDTO dto) {
        return loginService.autenticar(dto.toUsuario(), authenticationManager);
    }

}
