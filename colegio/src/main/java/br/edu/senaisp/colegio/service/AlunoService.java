package br.edu.senaisp.colegio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senaisp.colegio.model.Aluno;
import br.edu.senaisp.colegio.repository.AlunoRepository;
import jakarta.transaction.Transactional;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repo;
	
	@Transactional
	public Aluno gravarAluno(Aluno aluno) {
		return repo.save(aluno);	
	}
	
	

}
