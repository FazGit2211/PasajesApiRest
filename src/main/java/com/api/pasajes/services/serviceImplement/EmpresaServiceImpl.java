package com.api.pasajes.services.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.pasajes.models.Empresa;
import com.api.pasajes.models.Pasaje;
import com.api.pasajes.repositorys.EmpresaRepository;
import com.api.pasajes.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public ResponseEntity<Empresa> create(Empresa empresa) {
        return ResponseEntity.ok(empresaRepository.save(empresa));
    }

    @Override
    public ResponseEntity<Empresa> update(Integer id, Empresa empresa) {
        try {
            Optional<Empresa> buscarEmpresa = empresaRepository.findById(id);
            if (!buscarEmpresa.isPresent()) {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ResponseEntity.ok(empresaRepository.save(empresa));
    }

    @Override
    public ResponseEntity<Empresa> getById(Integer id) {
        return ResponseEntity.ok(empresaRepository.findById(id).get());
    }

    @Override
    public ResponseEntity<Empresa> addPasaje(String empresa, Pasaje pasaje) {
        Empresa buscarEmpresa = empresaRepository.findByNombre(empresa);
        if (buscarEmpresa != null) {
            if (!buscarEmpresa.getPasajes().contains(pasaje)) {
                buscarEmpresa.getPasajes().add(pasaje);
                return ResponseEntity.ok(empresaRepository.save(buscarEmpresa));
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public List<Empresa> getAllList() {
        return empresaRepository.findAll();
    }

}
