package br.ufsm.csi.poow2.spring_rest.repository;

import br.ufsm.csi.poow2.spring_rest.model.Reserva;
import br.ufsm.csi.poow2.spring_rest.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva,Integer> {


    @Query(value = "SELECT r.* FROM RESERVAS R JOIN QUADRAS Q ON Q.IDQUADRA = R.IDQUADRA WHERE Q.IDUSUARIO = ? ", nativeQuery = true)
    List<Reserva> getReservaByQuadra(@Param("idquadra") Integer idQuadra);


    @Query(value = "SELECT r.* FROM RESERVAS R JOIN CLIENTES CLI ON CLI.IDCLIENTE = R.IDCLIENTE WHERE CLI.IDUSUARIO = ? ", nativeQuery = true)
    List<Reserva> getReservaByCliente(@Param("idcliente") Integer idCliente);
}
