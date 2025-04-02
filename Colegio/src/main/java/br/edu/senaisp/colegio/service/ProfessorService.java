package br.edu.senaisp.colegio.service;

import br.edu.senaisp.colegio.model.Professor;
import br.edu.senaisp.colegio.model.Turma;
import br.edu.senaisp.colegio.repository.ProfessorRepository;
import br.edu.senaisp.colegio.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository repoProfessor;

    @Autowired
    private TurmaRepository repoTurma;

    public List<Professor> buscarTodos() {
        return repoProfessor.findAll();
    }

    public Professor buscarPorId(Long id) {
        return repoProfessor.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public Professor gravar(Professor professor) {
        try {
            Set<Turma> turmas = new HashSet<>();

            for (Turma turma : professor.getTurmas()) {
                turma = repoTurma.findById(turma.getId()).orElse(null);
                if (turma != null)
                    turmas.add(turma);
            }
            professor.setTurmas(turmas);
            return repoProfessor.save(professor);
        } catch (RuntimeException e) {
            throw new RuntimeException("Não foi possível incluir o professor!" + e.getMessage());
        }
    }

	public Professor excluir(Long id) {
		try {
			Professor professor = buscarPorId(id);
			if(professor != null) {
				repoProfessor.deleteById(id);
				return professor;
			}
		} catch (Exception e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
		return null;
	}
    



}
