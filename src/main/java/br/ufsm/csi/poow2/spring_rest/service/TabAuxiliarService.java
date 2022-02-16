package br.ufsm.csi.poow2.spring_rest.service;

import br.ufsm.csi.poow2.spring_rest.model.Cliente;
import br.ufsm.csi.poow2.spring_rest.model.TabAuxiliar;
import br.ufsm.csi.poow2.spring_rest.repository.TabAuxiliarRepository;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TabAuxiliarService {

    private final TabAuxiliarRepository tabAuxiliarRepository;

    public TabAuxiliarService(TabAuxiliarRepository tabAuxiliarRepository) {
        this.tabAuxiliarRepository = tabAuxiliarRepository;
    }

    public List<TabAuxiliar> getHorario(String quadra,String ambiente,String data)  {
        List<TabAuxiliar> t = new ArrayList<>();

        try{
           t = this.tabAuxiliarRepository.getHorario(Integer.parseInt(quadra),Integer.parseInt(ambiente),data);
        }catch (PersistenceException e ){
            return null;
        }
        return t;

    }
}
