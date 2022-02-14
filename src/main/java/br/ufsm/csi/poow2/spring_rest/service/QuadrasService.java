package br.ufsm.csi.poow2.spring_rest.service;

import br.ufsm.csi.poow2.spring_rest.dao.QuadraDAO;
import br.ufsm.csi.poow2.spring_rest.dto.QuadraDto;
import br.ufsm.csi.poow2.spring_rest.model.Quadra;

import br.ufsm.csi.poow2.spring_rest.repository.QuadraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuadrasService {


    private  QuadraRepository quadraRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public QuadrasService(QuadraRepository quadraRepository) {
        this.quadraRepository = quadraRepository;
    }

    public List<QuadraDto> getQuadras(){
        List<Quadra> quadras =this.quadraRepository.findAll();
        //List<Quadra> quadras = quadraRepository.findAll() ;

        List<QuadraDto> dto = Arrays.asList(modelMapper.map(quadras,QuadraDto[].class));

        return dto;
    }

}
