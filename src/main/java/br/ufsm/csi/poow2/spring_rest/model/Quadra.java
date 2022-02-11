package br.ufsm.csi.poow2.spring_rest.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "quadras")
public class Quadra {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idquadra")
    private Integer idQuadra;
    private String nome;
    @Column(name = "bairroend")
    private String bairroEnd;
    @Column(name = "numeroend")
    private String numeroEnd;
    @Column(name = "ruaend")
    private String ruaEnd;
    private String avaliacao;
    private String cnpj;

    @Column(name = "nroavaliacoes")
    private Integer nroAvaliacoes;


    @OneToMany( cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "idquadra")
    private List<Ambiente> ambientes;

    @OneToOne
    @JoinColumn(name="idusuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "quadra")
    private List<Reserva> reservas;

    public Integer getIdQuadra() {
        return idQuadra;
    }

    public void setIdQuadra(Integer idQuadra) {
        this.idQuadra = idQuadra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBairroEnd() {
        return bairroEnd;
    }

    public void setBairroEnd(String bairroEnd) {
        this.bairroEnd = bairroEnd;
    }

    public String getNumeroEnd() {
        return numeroEnd;
    }

    public void setNumeroEnd(String numeroEnd) {
        this.numeroEnd = numeroEnd;
    }

    public String getRuaEnd() {
        return ruaEnd;
    }

    public void setRuaEnd(String ruaEnd) {
        this.ruaEnd = ruaEnd;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Integer getNroAvaliacoes() {
        return nroAvaliacoes;
    }

    public void setNroAvaliacoes(Integer nroAvaliacoes) {
        this.nroAvaliacoes = nroAvaliacoes;
    }



    public List<Ambiente> getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(List<Ambiente> ambientes) {
        this.ambientes = ambientes;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
