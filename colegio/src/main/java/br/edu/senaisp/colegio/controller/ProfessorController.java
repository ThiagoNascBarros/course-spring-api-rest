package br.edu.senaisp.colegio.controller;

import br.edu.senaisp.colegio.model.Professor;
import br.edu.senaisp.colegio.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        try {
            return ResponseEntity.status(200).body(professorService.buscarTodos());
        }  catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> gravar(@RequestBody Professor professor) {
        try {
            return ResponseEntity.status(201).body(professorService.gravar(professor));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

}
