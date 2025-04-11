package br.edu.senaisp.colegio.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senaisp.colegio.model.Professor;
import br.edu.senaisp.colegio.model.Turma;
import br.edu.senaisp.colegio.repository.ProfessorRepository;
import br.edu.senaisp.colegio.repository.TurmaRepository;

@Service
public class ProfessorService {
	
	@Autowired
	ProfessorRepository repo;
	
	@Autowired
	TurmaRepository repoTurma;
	
	public List<Professor> buscarTodos(){
		return repo.findAll();
	}
	
	public Professor buscarPorId(Long id) {
		return repo.findById(id)
			.orElseThrow( 
					() -> new RuntimeException()
						);
	}
	
	
	public Professor gravar(Professor professor) {
		try {
			Set<Turma> turmas = new HashSet<>();
			
			for(Turma t : professor.getTurmas()) {
				t = repoTurma.findById( t.getId()  )
						.orElse(null);
				if (t != null)
				turmas.add( t );
			}
			professor.setTurmas(turmas);
			return repo.save(professor);
			
		} catch (Exception e) {
			throw new RuntimeException(
			"Não foi possível incluir o Professor."
			+ e.getMessage() ); 
		}
		
	}
	//alterar
	//excluir

	public Professor excluir(Long id) {
		Professor tmp = buscarPorId(id);
		if (tmp != null)
			repo.deleteById(id);
		
		if(buscarPorId(id) == null)
			return tmp;
		else
			throw new RuntimeException();
		
	}

	public Object alterar(Long id, Professor p) {
		try {
			Set<Turma> turmas = new HashSet<>();
			for(Turma t : p.getTurmas()) {
				t = repoTurma.findById( t.getId()  )
						.orElse(null);
				if (t != null)
				turmas.add( t );
			}
			p.setId(id);
			p.setTurmas(turmas);
			return repo.save(p);
			
		} catch (Exception e) {
			throw new RuntimeException(
			"Não foi possível incluir o Professor."
			+ e.getMessage() ); 
		}
	}

}
