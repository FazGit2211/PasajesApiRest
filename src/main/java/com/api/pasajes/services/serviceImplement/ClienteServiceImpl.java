package com.api.pasajes.services.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.pasajes.models.Cliente;
import com.api.pasajes.models.Pasaje;
import com.api.pasajes.repositorys.ClienteRepository;
import com.api.pasajes.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ResponseEntity<Cliente> create(Cliente cliente) {
        return ResponseEntity.ok(clienteRepository.save(cliente));
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public ResponseEntity<Cliente> addPasaje(Pasaje pasaje, Cliente cliente) {
        if (!cliente.getPasajes().contains(pasaje)) {
            cliente.getPasajes().add(pasaje);
            return ResponseEntity.ok(clienteRepository.save(cliente));
        }
        return ResponseEntity.badRequest().build();
    }

}
