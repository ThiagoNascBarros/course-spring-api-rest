package br.edu.senaisp.colegio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.senaisp.colegio.model.Aluno;
import br.edu.senaisp.colegio.model.Disciplina;
import br.edu.senaisp.colegio.repository.DisciplinaRepository;

@Service
public class DisciplinaService {
	@Autowired
	private DisciplinaRepository repo;

	public Disciplina gravar(Disciplina d) {
		try {
			d = repo.save(d);
			return d;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	public List<Disciplina> buscarTodos() {
		return repo.findAll();
	}

	public Optional<Disciplina> buscarPorId(Long id) {
		return repo.findById(id);
	}

	public Disciplina alterar(Long id, Disciplina disc) {
		Optional<Disciplina> op = repo.findById(id);

		if (op.isPresent()) {
			disc.setId(id);
			return repo.save(disc);
		} else
			return null;
	}

	public boolean excluirPorId(Long id) {
		try {
			repo.deleteById(id);
			return !(repo.existsById(id));
				
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
