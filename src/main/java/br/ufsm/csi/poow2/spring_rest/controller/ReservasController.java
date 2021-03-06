package br.ufsm.csi.poow2.spring_rest.controller;


import br.ufsm.csi.poow2.spring_rest.dto.ReservaDTO;
import br.ufsm.csi.poow2.spring_rest.dto.ReservaQuadraDTO;
import br.ufsm.csi.poow2.spring_rest.model.Reserva;
import br.ufsm.csi.poow2.spring_rest.model.Usuario;
import br.ufsm.csi.poow2.spring_rest.repository.ClienteRepository;
import br.ufsm.csi.poow2.spring_rest.repository.ReservaRepository;
import br.ufsm.csi.poow2.spring_rest.repository.UsuarioRepository;
import br.ufsm.csi.poow2.spring_rest.security.JWTUtil;
import br.ufsm.csi.poow2.spring_rest.service.ClienteService;
import br.ufsm.csi.poow2.spring_rest.service.ReservaService;
import br.ufsm.csi.poow2.spring_rest.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    private ClienteRepository clienteRepository;
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
    @CrossOrigin
    @PostMapping("/novaReserva")
    public String novaReserva(@RequestHeader("Authorization")String header,@RequestBody Reserva reserva){
        String status = "";
        System.out.println(reserva.getIdReserva());
        try{
            String user = new JWTUtil().getUsernameToken(header);
            System.out.println("[Requisição de nova reserva do usuário ]: "+user);
            Integer idUsuario = new UsuarioService(usuarioRepository).getUsuario(user).getIdUsuario();
            Integer idCliente = new ClienteService(clienteRepository).getClienteByUsuario(idUsuario).getIdCliente();

            System.out.println("[Cadastrando nova reserva ]: ");
            status=new ReservaService(reservaRepository).novaReserva(idCliente,reserva);


        }catch (Exception e ){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Não foi possível cadastrar a nova reserva", e);
        }
        return status;
    }


    @CrossOrigin
    @PostMapping("/deletarReserva")
    public String deletarReserva(@RequestHeader("Authorization")String header,@RequestBody Reserva reserva){
        String status;
        String user;

        System.out.println(reserva.getIdReserva());
        try{
            user= new JWTUtil().getUsernameToken(header);
            System.out.println("[Requisição de deletar reserva do usuário ]: "+user);
            Integer idUsuario = new UsuarioService(usuarioRepository).getUsuario(user).getIdUsuario();
            Integer idCliente = new ClienteService(clienteRepository).getClienteByUsuario(idUsuario).getIdCliente();

            System.out.println("[Deletando reserva ]: ");
            status=new ReservaService(reservaRepository).deletarReserva(idCliente,reserva);


        }catch (Exception e ){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Não foi possível cadastrar a nova reserva", e);
        }
        return status;
    }
}
