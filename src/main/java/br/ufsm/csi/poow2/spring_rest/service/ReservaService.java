package br.ufsm.csi.poow2.spring_rest.service;

import br.ufsm.csi.poow2.spring_rest.dto.ReservaDTO;
import br.ufsm.csi.poow2.spring_rest.model.Cliente;
import br.ufsm.csi.poow2.spring_rest.model.Reserva;

import br.ufsm.csi.poow2.spring_rest.repository.ReservaRepository;

import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
        String verificador = "sucess";
        try{
            c.setIdCliente(idCliente);
            reserva.setCliente(c);
            reserva.setAtivo("S");
            verificador = this.validarReserva(reserva);

            if (verificador.equals("sucess")) {
                this.reservaRepository.save(reserva);
            }

        }catch (PersistenceException e ){
            return "Não foi possível cadastrar a nova reserva";
        }
        return verificador;

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

    private String validarReserva(Reserva reserva){
        try{
            Date dataAtual  = new Date();
            Date dataReserva=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(reserva.getData()+" "+reserva.getHorario());

            System.out.println("Data atual: "+dataAtual);
            System.out.println("Data reserva: "+dataReserva);
            if (dataAtual.after(dataReserva)){
                System.out.println("Data de reserva deve ser maior que a atual");
                return "data";
            }
        }catch (Exception e ){
            e.printStackTrace();
            return "erro";
        }

        return "sucess";
    }
}
