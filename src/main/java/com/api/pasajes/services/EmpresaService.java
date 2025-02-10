package com.api.pasajes.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.pasajes.models.Empresa;
import com.api.pasajes.models.Pasaje;

public interface EmpresaService {

    ResponseEntity<Empresa> create(Empresa empresa);

    ResponseEntity<Empresa> update(Integer id, Empresa empresa);

    List<Empresa> getEmpresas();

    ResponseEntity<Empresa> getById(Integer id);

    ResponseEntity<Empresa> addPasaje(Integer id, Pasaje pasaje);
}
