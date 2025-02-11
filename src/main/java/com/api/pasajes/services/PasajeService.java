package com.api.pasajes.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.pasajes.models.Cliente;
import com.api.pasajes.models.Pasaje;

public interface PasajeService {
    ResponseEntity<Pasaje> create(Cliente cliente, String formaPago, Float valor, String ciudadDestino,
            String empresa);

    List<Pasaje> getAllList();

    ResponseEntity<Pasaje> getById(Integer id);
}
