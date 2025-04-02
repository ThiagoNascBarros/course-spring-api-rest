package br.edu.senaisp.colegio.repository;

import br.edu.senaisp.colegio.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
