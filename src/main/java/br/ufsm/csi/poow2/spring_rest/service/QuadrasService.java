package br.ufsm.csi.poow2.spring_rest.service;

import br.ufsm.csi.poow2.spring_rest.dao.QuadraDAO;
import br.ufsm.csi.poow2.spring_rest.dto.QuadraDto;
import br.ufsm.csi.poow2.spring_rest.model.Quadra;

import br.ufsm.csi.poow2.spring_rest.repository.QuadraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuadrasService {

    @Autowired
    private final QuadraRepository quadraRepository;

    public QuadrasService(QuadraRepository quadraRepository) {
        this.quadraRepository = quadraRepository;
    }

    public List<Quadra> getQuadras(){
        //List<QuadraDto> quadras =this.quadraToDto(new QuadraDAO().getQuadras());
        List<Quadra> quadras = quadraRepository.findAll() ;

        return quadras;
    }

    public List<QuadraDto> quadraToDto(List<Quadra> quadras){

        List<QuadraDto> dtos = new ArrayList<>();
        for(Quadra quadra: quadras){
            QuadraDto dto = new QuadraDto();
            dto.setIdQuadra(quadra.getIdQuadra());
            dto.setNome(quadra.getNome());
            dto.setCnpj(quadra.getCnpj());
            dto.setNroAvaliacoes(quadra.getNroAvaliacoes());
            dto.setAvaliacao(quadra.getAvaliacao());
            dto.setBairroEnd(quadra.getBairroEnd());
            dto.setRuaEnd(quadra.getRuaEnd());
            dto.setNumeroEnd(quadra.getNumeroEnd());
            dtos.add(dto);
        }

        return dtos;
    }
}
