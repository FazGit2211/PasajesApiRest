package com.api.pasajes.services.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.pasajes.models.Ciudad;
import com.api.pasajes.repositorys.CiudadRepository;
import com.api.pasajes.services.CiudadService;

@Service
public class CiudadServiceImpl implements CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    @Override
    public ResponseEntity<Ciudad> create(Ciudad ciudad) {
        return ResponseEntity.ok(ciudadRepository.save(ciudad));
    }

    @Override
    public List<Ciudad> getAll() {
        return ciudadRepository.findAll();
    }

}
