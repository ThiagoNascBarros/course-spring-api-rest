package br.edu.senaisp.Escola.controller;

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

import br.edu.senaisp.Escola.model.Aluno;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
	
	@GetMapping
	public String nameAluno() {
		return "Olá aluno";
	}
	
	@GetMapping("/{id}")
	// A classe ResponseEntity é uma extensão da classe HttpEntity que adiciona um código de status HTTP a uma resposta. 
	// Isso é útil para retornar respostas personalizadas e detalhadas para os clientes, como diferentes códigos de status para sucesso ou erro.
	public ResponseEntity<Aluno> buscarId(@PathVariable Long id) {
		Aluno a = new Aluno();
		a.setId(id);
		a.setCpf("342.234.914-91");
		a.setNome("Pedro alves");
//		Devolvendo em JSON a entidade Aluno
//		return new ResponseEntity<Aluno>(a, HttpStatus.OK);
		return ResponseEntity.status(200).body(a); 
	}
	
	@PostMapping
	public Aluno insertAluno(@RequestBody Aluno aluno) {
		return aluno;
	}
	
	@PutMapping
	public void alteraAluno(String nome) {
		System.out.println("Altera nome " + nome);
	}
	
	@DeleteMapping
	public void deletarAluno(String nome) {
		System.out.println("Aluno " + nome + " deletado...");
	}
	

}