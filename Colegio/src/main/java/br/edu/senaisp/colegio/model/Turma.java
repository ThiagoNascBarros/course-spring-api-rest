package br.edu.senaisp.colegio.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// @Entity -> Falando que a classe é uma entidade de banco de dados
// @Id -> Para definir que irá ser uma chave primária
// @GenerateValue(strategy = estrategia que você escolhe) -> Para gerar valores -> AUTO_INCREMENT
// @Size -> Usamos para definir o minimo e o maximo de um valor -> Desta forma (min = 2, max = 100)
//	1:N -> Uma turma para muitos alunos

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome não pode ser nulo")
    @Size(min = 2, max = 100)
    private String nome;

    @OneToMany(mappedBy = "turma", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Aluno> alunos = new ArrayList<>();

    @Embedded
    private Sala sala;

    @OneToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "turmas")
    private Set<Professor> professores = new HashSet<>();

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

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

	public Set<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(Set<Professor> professores) {
		this.professores = professores;
	}
    
    


}
