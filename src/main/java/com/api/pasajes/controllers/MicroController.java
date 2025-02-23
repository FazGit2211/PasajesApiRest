package com.api.pasajes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.pasajes.models.Micro;
import com.api.pasajes.services.serviceImplement.MicroServiceImpl;

@RestController
@RequestMapping(value = "/micro", produces = MediaType.APPLICATION_JSON_VALUE)
public class MicroController {

    @Autowired
    private MicroServiceImpl microServiceImpl;

    @PostMapping(value = "/add")
    public ResponseEntity<Micro> add(@RequestBody Micro micro){
        return microServiceImpl.create(micro);
    }

    @GetMapping(value = "/getAll")
    public List<Micro> getAll(){
        return microServiceImpl.getAll();
    }

    @PutMapping(value = "/addEmpresa/{nombreMicro}/{nombreEmpresa}")
    public ResponseEntity<Micro> addEmpresa(@PathVariable String nombreMicro, @PathVariable String nombreEmpresa){
        return microServiceImpl.addEmpresa(nombreMicro, nombreEmpresa);
    }
}
