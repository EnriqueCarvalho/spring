package br.ufsm.csi.poow2.spring_rest.service;

import br.ufsm.csi.poow2.spring_rest.dao.ReservaDAO;
import br.ufsm.csi.poow2.spring_rest.dao.UsuarioDAO;
import br.ufsm.csi.poow2.spring_rest.dto.QuadraDto;
import br.ufsm.csi.poow2.spring_rest.dto.ReservaDTO;
import br.ufsm.csi.poow2.spring_rest.model.Reserva;
import br.ufsm.csi.poow2.spring_rest.model.Usuario;
import br.ufsm.csi.poow2.spring_rest.repository.ReservaRepository;
import br.ufsm.csi.poow2.spring_rest.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
}
