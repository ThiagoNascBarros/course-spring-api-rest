package br.edu.senaisp.colegio.service;

import br.edu.senaisp.colegio.exception.RecursoNotFound;
import br.edu.senaisp.colegio.model.Usuario;
import br.edu.senaisp.colegio.repository.UsuarioRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class LoginService implements UserDetailsService {

    private String chaveSecreta = "Xa!xa=123@";

    public String autenticar(Usuario usuario, AuthenticationManager authenticationManager) {
        UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(usuario.getLogin(), usuario.getPassword());
        Authentication usuarioLogado = authenticationManager.authenticate(upat);
        return gerarToken((Usuario) usuarioLogado.getPrincipal());
    }

    public String gerarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(chaveSecreta);
            String token = JWT.create().withIssuer("API Colegio").withSubject(usuario.getLogin()).withExpiresAt(Instant.now().plusSeconds(3600)).sign(algorithm);
            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar token JWT: " + e.getMessage());
        }
    }

    @Autowired
    private UsuarioRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

//  Gerando token
    public String validarToken (String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(chaveSecreta);
            return JWT.require(algorithm).withIssuer("API Colegio").build().verify(token).getSubject();
        } catch (JWTCreationException | IllegalArgumentException | JWTVerificationException e) {
            throw new RuntimeException("Token inválido: " + e.getMessage());
        }
    }

}
