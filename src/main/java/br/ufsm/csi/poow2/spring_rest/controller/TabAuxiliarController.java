package br.ufsm.csi.poow2.spring_rest.controller;


import br.ufsm.csi.poow2.spring_rest.dto.ReservaDTO;
import br.ufsm.csi.poow2.spring_rest.model.Reserva;
import br.ufsm.csi.poow2.spring_rest.model.TabAuxiliar;
import br.ufsm.csi.poow2.spring_rest.repository.ReservaRepository;
import br.ufsm.csi.poow2.spring_rest.repository.TabAuxiliarRepository;
import br.ufsm.csi.poow2.spring_rest.security.JWTUtil;
import br.ufsm.csi.poow2.spring_rest.service.ReservaService;
import br.ufsm.csi.poow2.spring_rest.service.TabAuxiliarService;
import br.ufsm.csi.poow2.spring_rest.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tabauxiliar")
public class TabAuxiliarController {

    @Autowired
    private TabAuxiliarRepository tabAuxiliarRepository;

    @CrossOrigin
    @RequestMapping("/getHorarios")
    public List<TabAuxiliar> getReservasByQuadra(@RequestHeader("Authorization")String header,
                                                 @ModelAttribute("quadra") String quadra,
                                                 @ModelAttribute("ambiente") String ambiente,
                                                 @ModelAttribute("data") String data){



        String user = new JWTUtil().getUsernameToken(header);
        System.out.println("[Requisição de reservas do usuário ]: "+user);

        List<TabAuxiliar> tabs = new TabAuxiliarService(tabAuxiliarRepository).getHorario(quadra,ambiente,data);
        System.out.println(tabs);
        return tabs;
    }

}
