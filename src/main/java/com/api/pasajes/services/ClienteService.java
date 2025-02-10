package com.api.pasajes.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.pasajes.models.Cliente;

public interface ClienteService {
    ResponseEntity<Cliente> create(Cliente cliente);

    List<Cliente> getAllClientes();
}
