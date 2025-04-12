package br.edu.senaisp.colegio.service;

import br.edu.senaisp.colegio.model.Avaliacoes;
import br.edu.senaisp.colegio.repository.AvaliacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacoesService {

    @Autowired
    private AvaliacoesRepository repoAvaliacoes;

    public Avaliacoes createdAvaliation(Avaliacoes avaliacoes) {
        return repoAvaliacoes.save(avaliacoes);
    }

    public List<Avaliacoes> getAvaliations() {
        return repoAvaliacoes.findAll();
    }

}
