package br.ufsm.csi.poow2.spring_rest.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ambientes")
public class Ambiente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idambiente")
    private Integer idAmbiente;


    private String nome;
    private String descricao;

    @Column(name = "capacidademax")
    private Integer capacidadeMax;

/*    @OneToMany()
    @JoinColumn(name="idambiente")
    private List<Reserva> reservas;*/

    /*@ManyToOne
    @JoinColumn(name = "idquadra")
    private Quadra quadra;*/


    public Integer getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(Integer idAmbiente) {
        this.idAmbiente = idAmbiente;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCapacidadeMax() {
        return capacidadeMax;
    }

    public void setCapacidadeMax(Integer capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    /*public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }*/
}
