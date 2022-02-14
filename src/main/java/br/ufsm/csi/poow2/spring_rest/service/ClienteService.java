package br.ufsm.csi.poow2.spring_rest.service;

import br.ufsm.csi.poow2.spring_rest.model.Cliente;
import br.ufsm.csi.poow2.spring_rest.model.Usuario;
import br.ufsm.csi.poow2.spring_rest.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente getClienteByUsuario(Integer idUsuario){

        return this.clienteRepository.getClienteByUsuario(idUsuario);
    }

}
