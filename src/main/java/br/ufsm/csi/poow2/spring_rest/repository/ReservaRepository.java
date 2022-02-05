package br.ufsm.csi.poow2.spring_rest.repository;

import br.ufsm.csi.poow2.spring_rest.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva,Integer> {
}
