package br.edu.senaisp.colegio.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.colegio.model.Turma;
import br.edu.senaisp.colegio.service.TurmaService;

@RestController
@RequestMapping("/api/turma")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;

	@GetMapping
	public ResponseEntity buscarTodos() {
		try {
			List<Turma> turmas = turmaService.exibirTurmas();
			if (!turmas.isEmpty())
				return ResponseEntity.status(200).body(turmas);
			else
				return ResponseEntity.status(500).body(null);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}

	@GetMapping("{id}")
	public ResponseEntity buscarUmaTurma(@PathVariable Long id) {
		try {
			Turma turma = turmaService.exibirUmaTurma(id);
			if (turma == null)
				return ResponseEntity.status(404).build();
			else
				return ResponseEntity.status(200).body(turma);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e);
		}
	}

	@PostMapping
	public ResponseEntity inserir(@RequestBody Turma turma) {
		try {
			Turma turmaCriada = turmaService.gravarTurma(turma);
			return ResponseEntity.status(201).body(turmaCriada);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity alterar(@PathVariable Long id, @RequestBody Turma turma) {
		try {
			Turma t = turmaService.alterarPorId(id, turma);
			return ResponseEntity.status(200).body(t);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deletarTurma(@PathVariable Long id) {
		try {
			Turma turma = turmaService.excluirPorId(id);
			if (turma == null)
				return ResponseEntity.status(404).build();
			else
				return ResponseEntity.status(200).body(turma);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}

}
