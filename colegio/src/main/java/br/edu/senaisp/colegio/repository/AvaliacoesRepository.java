package br.edu.senaisp.colegio.repository;

import br.edu.senaisp.colegio.model.Avaliacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacoesRepository extends JpaRepository<Avaliacoes, Long> {
}
