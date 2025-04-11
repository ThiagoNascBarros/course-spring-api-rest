package br.edu.senaisp.colegio.model.mapper;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.edu.senaisp.colegio.model.Disciplina;
import br.edu.senaisp.colegio.model.dto.DisciplinaDTO;

@Component
public class DisciplinaMapper {

	public Disciplina toDisciplina(DisciplinaDTO dto) {
		Disciplina tmp = new Disciplina();
		tmp.setId(dto.id());
		tmp.setTitulo(dto.titulo());
		tmp.setDuracaoH(dto.duracaoH());
		return tmp;
	}
	
	public DisciplinaDTO toDisciplinaDTO(Disciplina disc) {
		return new DisciplinaDTO(
				disc.getId(), 
				disc.getTitulo(), 
				disc.getDuracaoH());
	}	
	
}
