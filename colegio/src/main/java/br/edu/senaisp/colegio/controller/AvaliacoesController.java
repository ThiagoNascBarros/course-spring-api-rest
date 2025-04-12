package br.edu.senaisp.colegio.controller;

import br.edu.senaisp.colegio.model.Avaliacoes;
import br.edu.senaisp.colegio.service.AvaliacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacoesController {

    @Autowired
    private AvaliacoesService avaliacoesService;

    @GetMapping
    public ResponseEntity<?> getAvalations() {
        return ResponseEntity.status(200).body(avaliacoesService.getAvaliations());
    }

    @PostMapping
    public ResponseEntity<?> createdAvaliations(@RequestBody Avaliacoes avaliacoes) {
        return ResponseEntity.status(201).body(avaliacoesService.createdAvaliation(avaliacoes));
    }

}
