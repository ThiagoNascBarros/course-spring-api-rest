package br.edu.senaisp.colegio.controller;

import br.edu.senaisp.colegio.model.Usuario;
import br.edu.senaisp.colegio.model.dto.UsuarioSaidaDTO;
import br.edu.senaisp.colegio.service.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioSaidaDTO>> buscarTodos(@RequestParam int page, @RequestParam int qtd) {
        return ResponseEntity.status(200).body(usuarioService.buscarTodos(PageRequest.of(page, qtd)));
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(200).body(usuarioService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
        return ResponseEntity.status(201).body(usuarioService.gravar(usuario));
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> alterar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return ResponseEntity.status(200).body(usuarioService.alterar(id, usuario));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Usuario> deletar(@PathVariable Long id) {
        usuarioService.excluirPorId(id);
        return ResponseEntity.status(200).build();
    }

}
