package br.edu.senaisp.colegio.model.dto;

import br.edu.senaisp.colegio.model.EPerfil;
import br.edu.senaisp.colegio.model.EStatus;
import br.edu.senaisp.colegio.model.Usuario;

public record UsuarioEntradaDTO (String login, String senha){

    public Usuario toUsuario() {
        Usuario u = new Usuario();
        u.setLogin(login);
        u.setSenha(senha);
        return u;
    }

}
