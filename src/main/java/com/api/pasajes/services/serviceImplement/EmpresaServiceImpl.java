package com.api.pasajes.services.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.pasajes.models.Empresa;
import com.api.pasajes.models.Micro;
import com.api.pasajes.models.Pasaje;
import com.api.pasajes.repositorys.EmpresaRepository;
import com.api.pasajes.repositorys.MicroRepository;
import com.api.pasajes.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private MicroRepository microRepository;

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
        if (buscarEmpresa != null || pasaje != null) {
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

    @Override
    public ResponseEntity<Empresa> addMicro(String empresaNombre, String microNombre) {
        Empresa empresa = empresaRepository.findByNombre(empresaNombre);
        Micro micro = microRepository.findByNombre(microNombre);
        if (empresa != null || micro != null) {
            if (!empresa.getMicros().contains(micro)) {
                empresa.getMicros().add(micro);
                return ResponseEntity.ok(empresaRepository.save(empresa));
            }
        }
        return ResponseEntity.badRequest().build();
    }

}
