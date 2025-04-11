package br.edu.senaisp.colegio.exception;

public class RecursoNotFound extends
					RuntimeException {
	private static final long serialVersionUID = 1L;

	public RecursoNotFound(String mensagem) {
		super(mensagem);
	}

}
