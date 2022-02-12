package br.ufsm.csi.poow2.spring_rest.controller;


import br.ufsm.csi.poow2.spring_rest.dto.ReservaDTO;
import br.ufsm.csi.poow2.spring_rest.model.Reserva;
import br.ufsm.csi.poow2.spring_rest.model.Usuario;
import br.ufsm.csi.poow2.spring_rest.repository.ReservaRepository;
import br.ufsm.csi.poow2.spring_rest.repository.UsuarioRepository;
import br.ufsm.csi.poow2.spring_rest.security.JWTUtil;
import br.ufsm.csi.poow2.spring_rest.service.ReservaService;
import br.ufsm.csi.poow2.spring_rest.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservasController {


    @Autowired
    private  ReservaRepository reservaRepository;
    @Autowired
    private  UsuarioRepository usuarioRepository;
    @Autowired
    private AuthenticationManager authenticationManager;



    @CrossOrigin
    @RequestMapping("/getReservas")
    public List<ReservaDTO> getReservasByQuadra(@RequestHeader("Authorization")String header){

        String user = new JWTUtil().getUsernameToken(header);
        System.out.println("[Requisição de reservas do usuário ]: "+user);
        Integer idUsuario = new UsuarioService(usuarioRepository).getUsuario(user).getIdUsuario();
        List<ReservaDTO> reservas =new ReservaService(reservaRepository).getReservasByQuadra(idUsuario);

        return reservas;
    }

    @CrossOrigin
    @RequestMapping("/getMinhasReservas")
    public List<ReservaDTO> getReservasByCliente(@RequestHeader("Authorization")String header){

        String user = new JWTUtil().getUsernameToken(header);
        System.out.println("[Requisição de reservas do usuário ]: "+user);
        Integer idUsuario = new UsuarioService(usuarioRepository).getUsuario(user).getIdUsuario();
        List<ReservaDTO> reservas =new ReservaService(reservaRepository).getReservasByCliente(idUsuario);

        return reservas;
    }
}
