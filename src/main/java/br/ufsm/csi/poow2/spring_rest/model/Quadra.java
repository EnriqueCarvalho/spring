package br.ufsm.csi.poow2.spring_rest.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "quadras")
public class Quadra extends Usuario{


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
    //private ArrayList<Ambiente> ambientes;


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



/*
    public ArrayList<Ambiente> getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(ArrayList<Ambiente> ambientes) {
        this.ambientes = ambientes;
    }*/

}
