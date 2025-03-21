package br.com.senaisp.Produto.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Produto {

//	Notação para sem valor nenhum
//	@NotNull
	
//	Notação para valor mas nâo pode ser branco -> " "
//	@NotBlank
	
//	Notação para valor com vázio mas sem espaço -> ""
//	@NotEmpty
	
//	Notação SIZE para estipular valor minimo e valor máximo
//	@Size
	
//	Notação faz validação de EMAIL!
//	@Email
	
//	Notação CPF do hibernate faz validação de CPF
//	@CPF
	
//	Notação Pattern para usar REGEX
//	@Pattern(regexp = "^\w+@\w+?\.[a-zA-Z]{2,3}$")
	
//	Notação MAX usada par definir o MAX apenas se for valores e não strings
// 	@MAX(valor maximo) -> @MAX(12)
	
	private int id;
	@Email
	private String email;
	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min = 1, max = 120)
	private String nome;
	@NotNull
	@Max(12)
	private int qntd;
	private double preco;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getQntd() {
		return qntd;
	}
	
	public void setQntd(int qntd) {
		this.qntd = qntd;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", qntd=" + qntd + ", preco=" + preco + "]";
	}
	
	

}
