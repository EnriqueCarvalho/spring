package br.ufsm.csi.poow2.spring_rest.dto;

import br.ufsm.csi.poow2.spring_rest.model.Ambiente;
import br.ufsm.csi.poow2.spring_rest.model.Cliente;

import java.sql.Date;
import java.sql.Time;

public class ReservaDTO {
    private Integer idReserva;
    private Date data;
    private Time horario;
    private ReservaQuadraDTO quadra;
    private Ambiente ambiente;
    private ClienteDTO cliente;

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public ReservaQuadraDTO getQuadra() {
        return quadra;
    }

    public void setQuadra(ReservaQuadraDTO quadra) {
        this.quadra = quadra;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
}
