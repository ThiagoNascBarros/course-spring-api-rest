package br.edu.senaisp.colegio.model.dto;

public class AlunoDTO {
	
	private Long id;
	private String nome;
	private String email;
	private Long turma_id;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getTurma_id() {
		return turma_id;
	}
	public void setTurma_id(Long turma_id) {
		this.turma_id = turma_id;
	}
	

}
