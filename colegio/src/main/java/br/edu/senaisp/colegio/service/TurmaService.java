package br.edu.senaisp.colegio.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senaisp.colegio.model.Turma;
import br.edu.senaisp.colegio.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository repo;
	
	public Turma gravarTurma(Turma t) {
		return repo.save(t);
	}
	
	public List<Turma> exibirTurmas(){
		return repo.findAll();
	}
	
	public Turma exibirUmaTurma(Long id) {
		Optional<Turma> turma = repo.findById(id);
//					 Se der errado retornar os erros
		return turma.orElse(null);
	}
	
	public Turma excluirPorId(Long id) {
		try {
			Turma turma = exibirUmaTurma(id);
			if(turma != null) {
				repo.deleteById(id);
				return turma;
			}
		} catch (Exception e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
		return null;
	}

	public Turma alterarPorId(Long id, Turma turma) {
		Optional<Turma> op = repo.findById(id);
		if(op.isPresent()) {
			turma.setId(id);
			return repo.save(turma);			
		} else
			return null;
	}

//	Map<String, String> message = new HashMap<>();
//	message.put("message", "Não existe o id");
	

}
