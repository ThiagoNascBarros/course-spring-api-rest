package br.edu.senaisp.colegio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// @Entity -> Falando que a classe é uma entidade de banco de dados
// @Id -> Para definir que irá ser uma chave primária
// @GenerateValue(strategy = estrategia que você escolhe) -> Para gerar valores -> AUTO_INCREMENT
// @Size -> Usamos para definir o minimo e o maximo de um valor -> Desta forma (min = 2, max = 100)

@Entity
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 2, max = 100)
	private String nome;
	
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
