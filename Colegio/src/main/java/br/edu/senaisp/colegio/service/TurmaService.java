package br.edu.senaisp.colegio.service;

import java.util.ArrayList;
import java.util.HashSet;
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

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository repoTurma;
	
	@Autowired
	private AlunoRepository repoAluno;
	
	@Autowired
	private ProfessorRepository repoProfessor;
	
	public Turma gravarTurma(Turma t) {
		Turma tmp = repoTurma.save(t);
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		for(Aluno a : t.getAlunos()) {
			a.setTurma(tmp);
			alunos.add(a);
		}
		
		alunos  = repoAluno.saveAll(alunos);
		tmp.setAlunos(alunos);
		
		Set<Professor> lista = new HashSet<Professor>();
		
		for (Professor p : t.getProfessores()) {
			Professor prof = repoProfessor.findById(p.getId()).orElse(null);
			if (prof != null) {
				lista.add(prof);
			}
		}
		
		t.setProfessores(lista);
		
//		Codigo do João		
//		repoProfessor.saveAll(t.getProfessores());
		return tmp;
	}
	
	public List<Turma> exibirTurmas(){
		return repoTurma.findAll();
	}
	
	public Turma exibirUmaTurma(Long id) {
		Optional<Turma> turma = repoTurma.findById(id);
//					 Se der errado retornar os erros
		return turma.orElse(null);
	}
	
	public Turma excluirPorId(Long id) {
		try {
			Turma turma = exibirUmaTurma(id);
			if(turma != null) {
				repoTurma.deleteById(id);
				return turma;
			}
		} catch (Exception e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
		return null;
	}

	public Turma alterarPorId(Long id, Turma turma) {
		Optional<Turma> op = repoTurma.findById(id);
		if(op.isPresent()) {
			turma.setId(id);
			return repoTurma.save(turma);			
		} else
			return null;
	}
	
	

//	Map<String, String> message = new HashMap<>();
//	message.put("message", "Não existe o id");
	

}
