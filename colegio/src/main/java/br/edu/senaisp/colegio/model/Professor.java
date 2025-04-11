package br.edu.senaisp.colegio.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Professor {
	
	@Id
	@GeneratedValue(strategy = 
					GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(length = 120)
	private String nome;
	
	@ManyToMany
	@JoinTable(name="professor_turma",
		joinColumns = @JoinColumn(name="professor_id"),
		inverseJoinColumns = @JoinColumn(name="turma_id") )
	private Set<Turma> turmas = new HashSet<>();

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

	public Set<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(Set<Turma> turmas) {
		this.turmas = turmas;
	}
	
}
