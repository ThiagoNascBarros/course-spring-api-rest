package br.edu.senaisp.colegio.service;

import br.edu.senaisp.colegio.exception.RecursoNotFound;
import br.edu.senaisp.colegio.model.Usuario;
import br.edu.senaisp.colegio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repoUsuario;

    public List<Usuario> getUsers() {
        return repoUsuario.findAll();
    }

    public Usuario getUser(Long id) {
        return repoUsuario.findById(id).orElseThrow(() -> new RecursoNotFound("Usuário não existe"));
    }

    public Usuario createdUser(Usuario usuario) {
        return repoUsuario.save(usuario);
    }

    public Usuario updateUser(Usuario usuario, Long id) {
        Optional<Usuario> usuarioOptional = repoUsuario.findById(id);
        if (usuarioOptional.isPresent()) {
            usuario.setId(id);
            return repoUsuario.save(usuario);
        } else
            return null;
    }

    public Usuario deleteUser(Long id) {
        try {
            Usuario user = getUser(id);
            if (user != null) {
                repoUsuario.deleteById(id);

                user = getUser(id);

                if (user == null) {
                    return user;
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return null;

    }


}
