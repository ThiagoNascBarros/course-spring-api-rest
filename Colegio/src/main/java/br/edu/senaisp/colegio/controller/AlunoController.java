package br.edu.senaisp.colegio.controller;

import br.edu.senaisp.colegio.exceptions.RecursoNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.colegio.model.Aluno;
import br.edu.senaisp.colegio.model.Turma;
import br.edu.senaisp.colegio.service.AlunoService;

import java.util.List;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> buscarTodos() {
        return ResponseEntity.status(200).body(alunoService.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        Aluno aluno = alunoService.buscarPorId(id);
        return ResponseEntity.status(200).body(aluno);
    }

    @PostMapping
    public ResponseEntity<Aluno> inserir(@RequestBody Aluno aluno) {
        return ResponseEntity.status(201).body(alunoService.gravarAluno(aluno));
    }

    @PutMapping("{id}")
    public ResponseEntity<Aluno> alterar(@PathVariable Long id, @RequestBody Aluno aluno) {
        return ResponseEntity.status(200).body(alunoService.alterarAluno(id, aluno));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Aluno> excluir(@PathVariable Long id) {
        Aluno aluno = alunoService.excluirPorId(id);
        return ResponseEntity.status(200).body(aluno);
    }


}
