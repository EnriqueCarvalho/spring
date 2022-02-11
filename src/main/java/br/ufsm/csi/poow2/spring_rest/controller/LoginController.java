package br.ufsm.csi.poow2.spring_rest.controller;

import br.ufsm.csi.poow2.spring_rest.model.Usuario;
import br.ufsm.csi.poow2.spring_rest.repository.UsuarioRepository;
import br.ufsm.csi.poow2.spring_rest.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<Object> autenticacao(@RequestBody Usuario usuario){

        System.out.println("login: "+usuario.getLogin());

        try{
            final Authentication authentication = this.authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(usuario.getLogin(), usuario.getSenha()));

            if(authentication.isAuthenticated()){
                //colocamos nossa instancia autenticada no contexto do spring security
                SecurityContextHolder.getContext().setAuthentication(authentication);

                System.out.println("Gerando token de autorizacao ****"+authentication.getAuthorities().toString());
                String token = new JWTUtil().geraToken(usuario);

                usuario.setToken(token);
                usuario.setSenha("");
                usuario.setRestricao(authentication.getAuthorities().toString());
                return new ResponseEntity<>(usuario, HttpStatus.OK);
            }

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Usuário ou senha incorretos!", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Usuário ou senha incorretos!", HttpStatus.BAD_REQUEST);
    }
}
