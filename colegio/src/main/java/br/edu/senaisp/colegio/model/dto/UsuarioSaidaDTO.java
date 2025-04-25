package br.edu.senaisp.colegio.model.dto;

import br.edu.senaisp.colegio.model.EPerfil;
import br.edu.senaisp.colegio.model.EStatus;

public record UsuarioSaidaDTO(String login, EPerfil perfil, EStatus eStatus){

}
