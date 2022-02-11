package br.ufsm.csi.poow2.spring_rest.repository;

import br.ufsm.csi.poow2.spring_rest.model.Ambiente;
import br.ufsm.csi.poow2.spring_rest.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Override
    List<Usuario> findAll();

    @Query(value = "SELECT * FROM USUARIOS U WHERE U.LOGIN = ? ", nativeQuery = true)
    Usuario findByLoginAndSenha(@Param("login") String login);

}
