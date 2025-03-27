package br.edu.senaisp.colegio.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Sala {

    private String nr_sala;
    private String predio;

    public String getNr_sala() {
        return nr_sala;
    }

    public void setNr_sala(String nr_sala) {
        this.nr_sala = nr_sala;
    }

    public String getPredio() {
        return predio;
    }

    public void setPredio(String predio) {
        this.predio = predio;
    }

}
