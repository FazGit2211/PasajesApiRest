package com.api.pasajes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.pasajes.models.Ciudad;
import com.api.pasajes.services.serviceImplement.CiudadServiceImpl;

@RestController
@RequestMapping(value = "/ciudad", produces = MediaType.APPLICATION_JSON_VALUE)
public class CiudadController {

    @Autowired
    private CiudadServiceImpl ciudadServiceImpl;

    @PostMapping(value = "/add")
    public ResponseEntity<Ciudad> add(@RequestBody Ciudad ciudad){
        return ciudadServiceImpl.create(ciudad);
    }

    @GetMapping(value = "/getAll")
    public List<Ciudad> getAllList(){
        return ciudadServiceImpl.getAll();
    }

}
