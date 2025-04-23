package br.edu.senaisp.colegio.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.senaisp.colegio.model.dto.ITurmaListaDTO;
import br.edu.senaisp.colegio.model.dto.TurmaListaSimplesDTO;
import br.edu.senaisp.colegio.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.senaisp.colegio.model.Aluno;
import br.edu.senaisp.colegio.model.Turma;
import br.edu.senaisp.colegio.service.TurmaService;

@RestController
@RequestMapping("/api/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private TurmaRepository repoTurma;

//    Paginação passando parâmetros
    @GetMapping("/paginacao")
    public List<Turma> testeJPA_Paginacao(@RequestParam int pag, @RequestParam int qnd) {
        return repoTurma.findAll(PageRequest.of(pag, qnd)).stream().toList();
    }

    @GetMapping
    public ResponseEntity<List<Turma>> buscarTodos() {
        return ResponseEntity.ok(turmaService.buscarTodos());
    }

    @GetMapping("/jpa")
    public String testeJPA() {
//        Turma tExemplo = new Turma();
        List<Turma> lista = new ArrayList<>();
//        tExemplo.setNome("Azure para estrangeiros");
//
//        lista = repoTurma.findAll(Example.of(tExemplo));

//        List<TurmaListaSimplesDTO> listaDTO = repoTurma.buscarListaCombo("Front-End com React");

        List<ITurmaListaDTO> listaDTO = repoTurma.buscarListaComboI("Front-End com React");

        listaDTO.forEach(t -> System.err.println(t.getNome() + "{" + t.getId() + "}"));

        return "Foi!";
    }

    @GetMapping("{id}")
    public ResponseEntity<Turma> buscarPorId(@PathVariable Long id) throws IOException {
        Turma t = turmaService.buscarPorId(id);
        return ResponseEntity.ok(t);
    }

    @PostMapping
    public ResponseEntity inserir(
            @RequestBody Turma turma) {

        try {
            Turma t = turmaService.gravarTurma(turma);
            return ResponseEntity.ok(t);

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity alterar(@PathVariable Long id,
                                  @RequestBody Turma turma) {

        try {
            Turma t = turmaService.alterarPorId(id, turma);
            return ResponseEntity.ok(t);

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }

    }


    @DeleteMapping("/{id}")
    public ResponseEntity excluirPorId(@PathVariable Long id) {
        try {
            Turma t = turmaService.excluirPorId(id);

            if (t == null)
                return ResponseEntity.notFound().build();
            else
                return ResponseEntity.ok(t);

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }

    }

}
