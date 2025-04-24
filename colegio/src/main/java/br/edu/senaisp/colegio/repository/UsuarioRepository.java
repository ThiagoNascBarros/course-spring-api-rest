package br.edu.senaisp.colegio.repository;

import br.edu.senaisp.colegio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
//    Usuario findByLogin(String login);
    Optional<Usuario> findByLogin(String login);

    boolean existsByLogin(String login);
}
