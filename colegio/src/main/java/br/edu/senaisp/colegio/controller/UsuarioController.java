package br.edu.senaisp.colegio.controller;

import br.edu.senaisp.colegio.model.Usuario;
import br.edu.senaisp.colegio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<List<Usuario>> getUser() {
        return ResponseEntity.status(200).body(usuarioService.getUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> getUsers(@PathVariable Long id) {
        return ResponseEntity.status(200).body(usuarioService.getUser(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> createdUser(@RequestBody Usuario usuario){
        usuarioService.createdUser(usuario);
        return ResponseEntity.status(201).body(usuario);
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable Long id, @RequestBody Usuario usuario) {
        return ResponseEntity.status(200).body(usuarioService.updateUser(usuario, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Usuario> deleteUser(@PathVariable Long id) {
        return ResponseEntity.status(200).body(usuarioService.deleteUser(id));
    }

}
