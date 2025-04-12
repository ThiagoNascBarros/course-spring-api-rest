package br.edu.senaisp.colegio.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Avaliacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate avaliacoesDt;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getAvaliacoesDt() {
        return avaliacoesDt;
    }

    public void setAvaliacoesDt(LocalDate avaliacoesDt) {
        this.avaliacoesDt = avaliacoesDt;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
