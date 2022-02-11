package br.ufsm.csi.poow2.spring_rest.security;

import br.ufsm.csi.poow2.spring_rest.dao.UsuarioDAO;
import br.ufsm.csi.poow2.spring_rest.model.Usuario;
import br.ufsm.csi.poow2.spring_rest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceCustomizado implements UserDetailsService {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    public UserDetailServiceCustomizado(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        System.out.println("username: "+login);

        Usuario usuario = new UsuarioDAO(usuarioRepository).getUsuario(login);


        if(usuario == null){
            throw  new UsernameNotFoundException("Usuário ou senha inválidos");
        }else{
            UserDetails user = User.withUsername(usuario.getLogin())
                    .password(  new BCryptPasswordEncoder().encode(usuario.getSenha()))
                    .authorities(usuario.getRestricao()).build();
            return user;
        }
    }
}
