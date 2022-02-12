package br.ufsm.csi.poow2.spring_rest.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idcliente")
    private Integer idCliente;
    private String nome;
    private String cpf;
    private String fone;

    @OneToOne
    @JoinColumn(name="idusuario")
    private Usuario usuario;

  /*  @OneToMany()
    @JoinColumn(name="idcliente")
    private List<Reserva> reservas;*/

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

/*    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }*/
}
