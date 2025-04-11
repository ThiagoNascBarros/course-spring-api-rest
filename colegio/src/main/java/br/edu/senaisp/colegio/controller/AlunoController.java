package br.edu.senaisp.colegio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import br.edu.senaisp.colegio.service.AlunoService;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService; 
	
	@GetMapping
	public ResponseEntity<List<Aluno>> buscarTodos() {
		return ResponseEntity.ok(
					alunoService.buscarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscarPorId(
			                     @PathVariable Long id) {
		Aluno a = alunoService.buscarPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(a);
	} 
	
	@PostMapping
	public ResponseEntity<Aluno> inserir(
			@RequestBody Aluno a) {
		
		return ResponseEntity.ok(
				alunoService.gravarAluno(a)
				);


	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Aluno> alterar(
			@PathVariable Long id,
			@RequestBody Aluno a
			) {
		
		a = alunoService.alterarAluno(a, id);

		return ResponseEntity.
					status(HttpStatus.OK).body(a);
 
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Aluno> excluir(
			@PathVariable Long id) {

		return ResponseEntity.ok(alunoService.excluirPorId(id));			

	}		
	
	

}
