package br.edu.senaisp.colegio.exceptions;

public class RecursoNotFound extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public RecursoNotFound(String message) {
        super(message);
    }

}
