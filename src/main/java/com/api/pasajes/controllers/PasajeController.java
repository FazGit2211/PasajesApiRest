package com.api.pasajes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.pasajes.models.Cliente;
import com.api.pasajes.models.Pasaje;
import com.api.pasajes.services.serviceImplement.PasajeServiceImpl;

@RestController
@RequestMapping(value = "/pasaje", produces = MediaType.APPLICATION_JSON_VALUE)
public class PasajeController {

    @Autowired
    private PasajeServiceImpl pasajeServiceImpl;

    @PostMapping(value = "/add/{formaPago}/{valor}/{ciudad}/{empresa}")
    public ResponseEntity<Pasaje> add(@RequestBody Cliente cliente, @PathVariable String formaPago,
            @PathVariable Float valor, @PathVariable String ciudad, @PathVariable String empresa) {
        return pasajeServiceImpl.create(cliente, formaPago, valor, ciudad, empresa);
    }

    @GetMapping(value = "/getAll")
    public List<Pasaje> getAllList() {
        return pasajeServiceImpl.getAllList();
    }

    @GetMapping(value = "/getById")
    public ResponseEntity<Pasaje> getById(@RequestParam String id){
        return pasajeServiceImpl.getById(Integer.parseInt(id));
    }
}
