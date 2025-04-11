package br.edu.senaisp.colegio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.colegio.model.Aluno;

@Repository
public interface AlunoRepository 
			extends JpaRepository<Aluno, Long>{

}
