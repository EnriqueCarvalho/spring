package br.ufsm.csi.poow2.spring_rest.repository;

import br.ufsm.csi.poow2.spring_rest.model.Reserva;
import br.ufsm.csi.poow2.spring_rest.model.TabAuxiliar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TabAuxiliarRepository extends JpaRepository<TabAuxiliar,Integer> {

    @Query(value = "select * from tabauxiliares tab where tab.cod_tabela = 1 and tab.valor not in  (select r.horario as valor from reservas r where r.idquadra = ? and r.idambiente = ? and r.data = ?)", nativeQuery = true)
    List<TabAuxiliar> getHorario( @Param("quadra") Integer quadra,
                                  @Param("ambiente")Integer ambiente,
                                  @Param("data")String data);

}
