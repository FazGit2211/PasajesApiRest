package com.api.pasajes.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.pasajes.models.Ciudad;

public interface CiudadService {
    ResponseEntity<Ciudad> create(Ciudad ciudad);

    List<Ciudad> getAll();
}
