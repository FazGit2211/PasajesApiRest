package com.api.pasajes.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.pasajes.models.Destino;
import com.api.pasajes.services.DestinoService;

@RestController
@RequestMapping(value = "/destino", produces = MediaType.APPLICATION_JSON_VALUE)
public class DestinoController {

    @Autowired
    private DestinoService destinoService;

    @PostMapping(value = "/add/{ciudadDestino}")
    public ResponseEntity<Destino> add(@PathVariable String ciudadDestino){
        return destinoService.create(ciudadDestino);
    }

    @GetMapping(value = "/getAll")
    public List<Destino> getAllList(){
        return destinoService.getDestinos();
    }
}
