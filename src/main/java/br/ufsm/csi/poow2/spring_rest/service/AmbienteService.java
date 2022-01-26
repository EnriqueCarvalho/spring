package br.ufsm.csi.poow2.spring_rest.service;

import br.ufsm.csi.poow2.spring_rest.model.Ambiente;

import java.util.ArrayList;

public class AmbienteService {

    public ArrayList<Ambiente> getAmbientes(Integer idQuadra){

        ArrayList<Ambiente> ambientes = new ArrayList<>();

        Ambiente amb1 = new Ambiente();
        amb1.setIdAmbiente(1);
        amb1.setDescricao("Quadra de futebol 7");
        amb1.setNome("Quadra 1 ");
        ambientes.add(amb1);
        return ambientes;
    }
}
