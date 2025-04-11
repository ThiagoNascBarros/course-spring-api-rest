package br.edu.senaisp.colegio.controller;

import br.edu.senaisp.colegio.model.Disciplina;
import br.edu.senaisp.colegio.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public ResponseEntity<?> exibirDisciplinas() {
        try {
            return ResponseEntity.status(200).body(disciplinaService.exibirDisciplinas());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> exibirUmaDisciplina(@PathVariable Long id) {
        try {
            return ResponseEntity.status(200).body(disciplinaService.exibirUmaDisciplina(id));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> gravarDisciplina(@RequestBody Disciplina disciplina) {
        try {
            Disciplina d = disciplinaService.gravarDisciplina(disciplina);
            return ResponseEntity.status(201).body(d);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> alterarDisciplina(@PathVariable Long id, @RequestBody Disciplina disciplina) {
        try {
            Disciplina d = disciplinaService.alterarDisciplina(id, disciplina);
            return ResponseEntity.status(200).body(d);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarDisciplina(@PathVariable Long id) {
        try {
            Disciplina disciplina = disciplinaService.deletarDisciplina(id);
            if (disciplina != null)
                return ResponseEntity.status(200).body(disciplina);
            else
                return ResponseEntity.status(400).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
