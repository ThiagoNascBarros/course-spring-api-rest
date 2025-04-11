package br.edu.senaisp.colegio.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Sala {
	private String nr;
	private String predio;
	
	public String getNr() {
		return nr;
	}
	public void setNr(String nr) {
		this.nr = nr;
	}
	public String getPredio() {
		return predio;
	}
	public void setPredio(String predio) {
		this.predio = predio;
	}

	
	
}
