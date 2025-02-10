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

import com.api.pasajes.models.Cliente;
import com.api.pasajes.services.serviceImplement.ClienteServiceImpl;

@RestController
@RequestMapping(value = "/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @PostMapping(value = "/add")
    public ResponseEntity<Cliente> add(@RequestBody Cliente cliente){
        return clienteServiceImpl.create(cliente);
    }

    @GetMapping(value = "/getAll")
    public List<Cliente> getAllList(){
        return clienteServiceImpl.getAllClientes();
    }
}
