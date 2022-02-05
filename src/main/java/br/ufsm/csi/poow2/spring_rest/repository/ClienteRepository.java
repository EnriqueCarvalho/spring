package br.ufsm.csi.poow2.spring_rest.repository;

import br.ufsm.csi.poow2.spring_rest.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
