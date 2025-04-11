package br.edu.senaisp.colegio.service;

import java.beans.Transient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senaisp.colegio.model.Aluno;
import br.edu.senaisp.colegio.model.Professor;
import br.edu.senaisp.colegio.model.Turma;
import br.edu.senaisp.colegio.repository.AlunoRepository;
import br.edu.senaisp.colegio.repository.ProfessorRepository;
import br.edu.senaisp.colegio.repository.TurmaRepository;
import jakarta.transaction.Transactional;

@Service
public class TurmaService {
	
	@Autowired
	TurmaRepository repoTurma;
	
	@Autowired
	AlunoRepository repoAluno;

	@Autowired
	ProfessorRepository repoProfessor;	
	
	public List<Turma> buscarTodos(){
		return repoTurma.findAll();
	}
	
	public Turma buscarPorId(Long id) throws IOException {
		throw new IOException();
		
		//Optional<Turma> op = repoTurma.findById(id);
		
		//return op.orElseThrow(() -> 	new RuntimeException("Só pra Testar"));
	}

	
	
	
	
	
	
	
	public Turma gravarTurma(Turma t){
		
		Set<Professor> lista = new HashSet<>();
		for (Professor p : t.getProfessores()) {
		    Professor prof = repoProfessor.findById(p.getId())
			.orElse(null);
		    if (prof != null) {
		    	System.err.println(prof.getId());
		    	lista.add(prof);
		    }
		}
		
		t.setProfessores(lista);
		
		Turma tmp = repoTurma.save(t);
		List<Aluno> alunos = new ArrayList<Aluno>();
		for (Aluno a : t.getAlunos()) {
			a.setTurma(tmp);
			alunos.add(a);
		}
		alunos = repoAluno.saveAll(alunos);
		tmp.setAlunos(alunos);
		
		return tmp;
		
	}

	public Turma excluirPorId(Long id) {
		try {
			Turma t = buscarPorId(id);
			if (t != null) {
				repoTurma.deleteById(id);
				return t;
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
		
		return null;
	}

	public Turma alterarPorId(Long id, Turma turma) {
	      Optional<Turma> op = repoTurma.findById(id);
	      
	      if (op.isPresent()) {
	    	  turma.setId(id);
	      	  return repoTurma.save(turma);
	      }
	      else
	    	  return null;
	}
	
	

}
