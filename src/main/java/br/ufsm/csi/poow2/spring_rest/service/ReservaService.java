package br.ufsm.csi.poow2.spring_rest.service;

import br.ufsm.csi.poow2.spring_rest.dto.ReservaDTO;
import br.ufsm.csi.poow2.spring_rest.model.Cliente;
import br.ufsm.csi.poow2.spring_rest.model.Reserva;

import br.ufsm.csi.poow2.spring_rest.repository.ReservaRepository;

import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.sql.SQLException;

import java.util.Arrays;
import java.util.List;


@Service
public class ReservaService {

    private ModelMapper modelMapper = new ModelMapper();
    private final ReservaRepository reservaRepository;
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }




    public List<ReservaDTO> getReservasByQuadra(Integer id){

        List<Reserva> reservas = this.reservaRepository.getReservaByQuadra(id);

        List<ReservaDTO> dto = Arrays.asList(modelMapper.map(reservas, ReservaDTO[].class));
        return  dto;
    }

    public List<ReservaDTO> getReservasByCliente(Integer id){

        List<Reserva> reservas = this.reservaRepository.getReservaByCliente(id);

        List<ReservaDTO> dto = Arrays.asList(modelMapper.map(reservas, ReservaDTO[].class));
        return  dto;
    }

    public String novaReserva(Integer idCliente,Reserva reserva) throws SQLException{
        Cliente c = new Cliente();
        try{
            c.setIdCliente(idCliente);
            reserva.setCliente(c);
            reserva.setAtivo("S");
            this.reservaRepository.save(reserva);

        }catch (PersistenceException e ){
            return "Não foi possível cadastrar a nova reserva";
        }
        return "sucess";

    }

    public String deletarReserva(Integer idCliente,Reserva reserva) throws SQLException{
        Cliente c = new Cliente();
        try{
            c.setIdCliente(idCliente);
            reserva.setCliente(c);
            reserva.setAtivo("N");
            this.reservaRepository.save(reserva);

        }catch (PersistenceException e ){
            return "Não foi possível deletar a reserva";
        }
        return "sucess";

    }
}
