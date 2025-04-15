package br.edu.senaisp.colegio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.colegio.model.Turma;

import java.util.List;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long>{

//    1. Derived Query Methods
    List<Turma> findByNome(String nome);
    long countByNome(String nome);
    List<Turma> findByNomeContains(String nome);
    List<Turma> findByNomeNotContains(String nome);

}
