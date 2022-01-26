package br.ufsm.csi.poow2.spring_rest.dto;

import br.ufsm.csi.poow2.spring_rest.model.Ambiente;
import br.ufsm.csi.poow2.spring_rest.model.Quadra;

import java.util.ArrayList;
import java.util.List;

public class QuadraDto {

    private Integer idQuadra;
    private String nome;
    private String bairroEnd;
    private String numeroEnd;
    private String ruaEnd;
    private String avaliacao;
    private String cnpj;
    private Integer nroAvaliacoes;
    private ArrayList<Ambiente> ambientes;



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

    public ArrayList<Ambiente> getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(ArrayList<Ambiente> ambientes) {
        this.ambientes = ambientes;
    }
}
