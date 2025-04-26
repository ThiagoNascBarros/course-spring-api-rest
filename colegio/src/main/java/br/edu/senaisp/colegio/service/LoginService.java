package br.edu.senaisp.colegio.service;

import br.edu.senaisp.colegio.exception.RecursoNotFound;
import br.edu.senaisp.colegio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

}
