package br.edu.senaisp.colegio.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// @Entity -> Falando que a classe é uma entidade de banco de dados
// @Id -> Para definir que irá ser uma chave primária
// @GenerateValue(strategy = estrategia que você escolhe) -> Para gerar valores -> AUTO_INCREMENT
// @Size -> Usamos para definir o minimo e o maximo de um valor -> Desta forma (min = 2, max = 100)
//	1:N -> Uma turma para muitos alunos

@Entity
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 2, max = 100)
	private String nome;
	@OneToMany(mappedBy = "turma")
	private List<Aluno> alunos = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
