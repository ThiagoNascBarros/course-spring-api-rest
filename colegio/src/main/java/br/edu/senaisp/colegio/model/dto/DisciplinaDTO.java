package br.edu.senaisp.colegio.model.dto;

import br.edu.senaisp.colegio.model.Disciplina;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DisciplinaDTO(
		Long id, 
		@NotBlank String titulo, 
		@Size(min=1) int duracaoH) {
	
	public Disciplina toDisciplina() {
		Disciplina tmp = new Disciplina();
		tmp.setId(this.id);
		tmp.setTitulo(this.titulo);
		tmp.setDuracaoH(this.duracaoH);
		return tmp;
	}

}
