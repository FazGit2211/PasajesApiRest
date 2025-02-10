package com.api.pasajes.services.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.pasajes.models.Ciudad;
import com.api.pasajes.models.Destino;
import com.api.pasajes.repositorys.CiudadRepository;
import com.api.pasajes.repositorys.DestinoRepository;
import com.api.pasajes.services.DestinoService;

@Service
public class DestinoServiceImpl implements DestinoService {

    @Autowired
    private DestinoRepository destinoRepository;

    @Autowired
    private CiudadRepository ciudadRepository;

    @Override
    public ResponseEntity<Destino> create(String ciudadDestino) {
        try {
            Ciudad ciudad = ciudadRepository.findByNombre(ciudadDestino);
            Destino destino = new Destino();
            destino.setCiudad(ciudad);
            return ResponseEntity.ok(destinoRepository.save(destino));
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public List<Destino> getDestinos() {
        return destinoRepository.findAll();
    }

}
