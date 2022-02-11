package br.ufsm.csi.poow2.spring_rest.dao;

import br.ufsm.csi.poow2.spring_rest.dto.QuadraDto;
import br.ufsm.csi.poow2.spring_rest.model.Quadra;
import br.ufsm.csi.poow2.spring_rest.repository.QuadraRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class QuadraDAO {


    private QuadraRepository quadraRepository;

    public QuadraDAO(QuadraRepository quadraRepository) {
        this.quadraRepository = quadraRepository;
    }

    private String status;
   /* public ArrayList<Quadra> getQuadras(){
        String sql;
        Statement statement;
        ResultSet resultSet;
        PreparedStatement preparedStatement;


        ArrayList<Quadra> quadras = new ArrayList<>();
        System.out.println("Buscando empresa...");
        try(Connection connection = new ConectaDB().getConexao()){
            sql = "SELECT * FROM QUADRAS";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Quadra quadra = new Quadra();
                quadra.setIdQuadra(resultSet.getInt("idquadra"));
                quadra.setNome(resultSet.getString("nome"));
                quadra.setCnpj(resultSet.getString("cnpj"));
                quadra.setNroAvaliacoes(resultSet.getInt("nroavaliacoes"));
                quadra.setBairroEnd(resultSet.getString("bairroend"));
                quadra.setRuaEnd(resultSet.getString("ruaend"));
                quadra.setNumeroEnd(resultSet.getString("numeroend"));
                quadras.add(quadra);
            }
            return quadras;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/

    public List<Quadra> getQuadras(){

        List<Quadra> quadras = quadraRepository.findAll();
        return quadras;
    }

}
