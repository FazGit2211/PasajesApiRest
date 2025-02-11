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

import com.api.pasajes.models.Empresa;
import com.api.pasajes.services.serviceImplement.EmpresaServiceImpl;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/empresa", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmpresaController {

    @Autowired
    private EmpresaServiceImpl empresaServiceImpl;

    @PostMapping(value =  "/add")
    public ResponseEntity<Empresa> add(@RequestBody Empresa empresa){
        return empresaServiceImpl.create(empresa);
    }

    @GetMapping(value = "/getAll")
    public List<Empresa> getAllList(){
        return empresaServiceImpl.getAllList();
    }

    @GetMapping(value = "/getById")
    public ResponseEntity<Empresa> getById(@RequestParam String id) {
        return empresaServiceImpl.getById(Integer.parseInt(id));
    }
}
