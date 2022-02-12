package br.ufsm.csi.poow2.spring_rest.dao;

import br.ufsm.csi.poow2.spring_rest.model.Reserva;
import br.ufsm.csi.poow2.spring_rest.repository.ReservaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Component
public class ReservaDAO {

    private final ReservaRepository reservaRepository;
    public ReservaDAO(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }


    public List<Reserva> getReservasByQuadra(Integer idQuadra){

        List<Reserva> reservas = reservaRepository.getReservaByQuadra(idQuadra);
        return  reservas;
    }


}
