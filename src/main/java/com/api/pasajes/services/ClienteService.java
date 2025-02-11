package com.api.pasajes.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.pasajes.models.Cliente;
import com.api.pasajes.models.Pasaje;

public interface ClienteService {
    ResponseEntity<Cliente> create(Cliente cliente);

    List<Cliente> getAllClientes();

    ResponseEntity<Cliente> addPasaje(Pasaje pasaje, Cliente cliente);
}
