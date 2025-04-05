package br.edu.senaisp.colegio.service;

import java.util.List;
import java.util.Optional;

import br.edu.senaisp.colegio.exceptions.RecursoNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senaisp.colegio.model.Aluno;
import br.edu.senaisp.colegio.repository.AlunoRepository;
import br.edu.senaisp.colegio.repository.TurmaRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repoAluno;
	
	@Autowired
	private TurmaRepository repoTurma;

	public Aluno gravarAluno(Aluno aluno) {
		try {
			return repoAluno.save(aluno);				
		} catch (Exception e) {
			throw new RuntimeException("Não foi possível adicionar o aluno");
		}
	}

	public List<Aluno> buscarTodos() {
		return repoAluno.findAll();
	}

	public Aluno buscarPorId(Long id) {
		Optional<Aluno> a = repoAluno.findById(id);
		return a.orElseThrow(() -> new RecursoNotFound("Aluno não encontrado"));
	}
	
	public Aluno alterarAluno(Long id, Aluno a) {
		Optional<Aluno> op = repoAluno.findById(id);
		
		if(op.isPresent()) {
			a.setId(id);
			return repoAluno.save(a);			
		} else
			throw new RecursoNotFound("Aluno não existe");
	}

	public Aluno excluirPorId(Long id) {
		try {
			Aluno aluno = buscarPorId(id);
			if(aluno != null) {
				repoAluno.deleteById(id);

				if (aluno == null)
					return aluno;

				throw new RuntimeException("Não foi possível excluir");
			}
		} catch(Exception e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
		return null;
	}

}
