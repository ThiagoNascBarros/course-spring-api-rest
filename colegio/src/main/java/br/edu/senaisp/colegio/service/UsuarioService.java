package br.edu.senaisp.colegio.service;

import br.edu.senaisp.colegio.model.Usuario;
import br.edu.senaisp.colegio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario gravar(Usuario usuario) {
        if (userRepository.existsByLogin(usuario.getLogin()))
            throw new RuntimeException("Login já existe");

        try {
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            return userRepository.save(usuario);
        } catch (Exception e) {
            throw new RuntimeException("Erro nos valores enviados para usuário: " + e);
        }
    }

    public Usuario alterar(Long id, Usuario usuario) {
        try {
            if (id == null || usuario == null)
                throw new RuntimeException("Erro nos valores enviados para usuário" );

            if (userRepository.findById(id).isEmpty())
                throw new RuntimeException("Usuário Inexistente!");

            usuario.setId(id);
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            return userRepository.save(usuario);
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Usuario buscarPorId(Long id) {
        if (id == null)
            throw new RuntimeException("Id não pode ser nulo");
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário inexistente"));
    }

    public Page<Usuario> buscarTodos(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public void excluirPorId(Long id) {
        if (id == null)
            throw new RuntimeException("Id não pode ser nulo");

        if (!userRepository.existsById(id))
            throw new RuntimeException("Usuário inexistente!");

        userRepository.deleteById(id);

        if (userRepository.existsById(id))
            throw new RuntimeException("Não foi possível excluir o usuário");
    }

}
