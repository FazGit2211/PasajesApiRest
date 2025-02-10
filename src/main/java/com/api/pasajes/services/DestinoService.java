package com.api.pasajes.services;
import java.util.List;

import org.springframework.http.ResponseEntity;
import com.api.pasajes.models.Destino;

public interface DestinoService {
    ResponseEntity<Destino> create(String ciudadDestino);

    List<Destino> getDestinos();
}
