package br.edu.senaisp.colegio.service;

import br.edu.senaisp.colegio.model.Disciplina;
import br.edu.senaisp.colegio.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository repoDisciplina;

    public List<Disciplina> exibirDisciplinas() {
        return repoDisciplina.findAll();
    }

    public Disciplina exibirUmaDisciplina(Long id) {
        Optional<Disciplina> disciplina = repoDisciplina.findById(id);
        return disciplina.orElse(null);
    }

    public Disciplina gravarDisciplina(Disciplina disciplina) {
        return repoDisciplina.save(disciplina);
    }

    public Disciplina alterarDisciplina(Long id, Disciplina disciplina) {
        Optional<Disciplina> d = repoDisciplina.findById(id);
        if (d.isPresent()) {
            disciplina.setId(id);
            return repoDisciplina.save(disciplina);
        } else
            return null;
    }

    public Disciplina deletarDisciplina(Long id) {
        Disciplina disciplina = exibirUmaDisciplina(id);
        try {
            if (disciplina != null) {
                repoDisciplina.delete(disciplina);
                return disciplina;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
        return null;
    }

}
