package br.ufsm.csi.poow2.spring_rest.dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConectaDB {

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/POOWII";
    private static final String USER = "postgres";
    private static final String SENHA = "moc7285be2";

    public Connection getConexao(){
        Connection conn = null;
        try {
            Class.forName(this.DRIVER);
            conn = DriverManager.getConnection(this.URL,this.USER,this.SENHA);
            return conn;
        }catch ( Exception e ){
            e.printStackTrace();
        }
        return null;
    }

}
