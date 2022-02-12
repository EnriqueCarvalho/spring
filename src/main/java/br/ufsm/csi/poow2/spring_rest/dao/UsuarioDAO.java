package br.ufsm.csi.poow2.spring_rest.dao;

import br.ufsm.csi.poow2.spring_rest.model.Usuario;
import br.ufsm.csi.poow2.spring_rest.repository.QuadraRepository;
import br.ufsm.csi.poow2.spring_rest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.Query;

@Component
public class UsuarioDAO {

    private UsuarioRepository usuarioRepository;
    public UsuarioDAO(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public Usuario getUsuario(String login){
        Usuario u = new Usuario();
        u = usuarioRepository.findByLoginAndSenha(login);
        return u;
    }
}
