package br.edu.senaisp.colegio.exception;

import java.time.LocalDateTime;

public class MensagemErro {
	
	private LocalDateTime dtOcorrencia;
	private String mensagem;
	private String detalhes;
	
	public MensagemErro(LocalDateTime dtOcorrencia, 
			String mensagem, String detalhes) {
		this.dtOcorrencia = dtOcorrencia;
		this.mensagem = mensagem;
		this.detalhes = detalhes;
	}

	public LocalDateTime getDtOcorrencia() {
		return dtOcorrencia;
	}

	public void setDtOcorrencia(LocalDateTime dtOcorrencia) {
		this.dtOcorrencia = dtOcorrencia;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	
	
	
	
	

}
