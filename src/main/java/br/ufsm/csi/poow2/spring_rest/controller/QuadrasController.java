package br.ufsm.csi.poow2.spring_rest.controller;


import br.ufsm.csi.poow2.spring_rest.dto.QuadraDto;
import br.ufsm.csi.poow2.spring_rest.model.Quadra;
import br.ufsm.csi.poow2.spring_rest.repository.QuadraRepository;
import br.ufsm.csi.poow2.spring_rest.service.QuadrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/quadras")
public class QuadrasController {

    @Autowired
    private final QuadraRepository quadraRepository;

    public QuadrasController(QuadraRepository quadraRepository) {
        this.quadraRepository = quadraRepository;
    }

    @RequestMapping("/getQuadras")
    public List<QuadraDto> getQuadras(){


        List<QuadraDto> quadras =new QuadrasService(quadraRepository).getQuadras();

        return quadras;
    }

}
