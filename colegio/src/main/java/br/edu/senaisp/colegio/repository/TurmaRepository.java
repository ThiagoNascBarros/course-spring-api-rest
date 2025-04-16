package br.edu.senaisp.colegio.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    Page<Turma> findAll(Pageable pageable);

//    List<Turma> findByNomeNotContainsOrdeByNomeDesc(String nome);

    @Query("SELECT t FROM Turma t WHERE t.nome LIKE %:nome%")
    List<Turma> buscarPorNomeLike(@Param("nome") String texto);

}
