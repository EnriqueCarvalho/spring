package br.ufsm.csi.poow2.spring_rest.repository;

import br.ufsm.csi.poow2.spring_rest.model.Cliente;
import br.ufsm.csi.poow2.spring_rest.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {


    @Query(value = "SELECT * FROM CLIENTES WHERE IDUSUARIO = ? ", nativeQuery = true)
    Cliente getClienteByUsuario(@Param("idusuario") Integer idusuario);
}
