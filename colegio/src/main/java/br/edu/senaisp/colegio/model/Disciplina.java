package br.edu.senaisp.colegio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.edu.senaisp.colegio.model.dto.DisciplinaDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Disciplina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String titulo;

	@Min(1)
	private int duracaoH;

	@OneToOne(mappedBy = "disciplina", cascade = CascadeType.ALL)
	@JsonIgnore
	private Turma turma;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracaoH() {
		return duracaoH;
	}

	public void setDuracaoH(int duracaoH) {
		this.duracaoH = duracaoH;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public DisciplinaDTO toDisciplinaDTO() {
		return new DisciplinaDTO(this.id, this.titulo, this.duracaoH);
	}
	
}
