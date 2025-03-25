package br.edu.senaisp.colegio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senaisp.colegio.model.Aluno;
import br.edu.senaisp.colegio.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repoAluno;

	public Aluno gravarAluno(Aluno aluno) {
		return repoAluno.save(aluno);	
	}

	public List<Aluno> buscarTodos() {
		return repoAluno.findAll();
	}

	public Aluno buscarPorId(Long id) {
		Optional<Aluno> a = repoAluno.findById(id);
		return a.orElse(null);
	}
	
	public Aluno alterarAluno(Long id, Aluno a) {
		Optional<Aluno> op = repoAluno.findById(id);
		
		if(op.isPresent()) {
			a.setId(id);
			return repoAluno.save(a);			
		} else
			return null;
	}

	public Aluno excluirPorId(Long id) {
		try {
			Aluno aluno = buscarPorId(id);
			if(aluno != null) {
				repoAluno.deleteById(id);
				return aluno;
			}
		} catch(Exception e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
		return null;
	}

}
