package br.ufsm.csi.poow2.spring_rest.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "tabauxiliares")
public class TabAuxiliar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtabela")
    private Integer idTabela;


    private Integer codTabela;
    @Nullable
    private Integer itemTabela;
    private String valor;


    public Integer getIdTabela() {
        return idTabela;
    }

    public void setIdTabela(Integer idTabela) {
        this.idTabela = idTabela;
    }

    public Integer getCodTabela() {
        return codTabela;
    }

    public void setCodTabela(Integer codTabela) {
        this.codTabela = codTabela;
    }

    public Integer getItemTabela() {
        return itemTabela;
    }

    public void setItemTabela(Integer itemTabela) {
        this.itemTabela = itemTabela;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
