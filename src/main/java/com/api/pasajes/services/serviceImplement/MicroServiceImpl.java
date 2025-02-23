package com.api.pasajes.services.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.pasajes.models.Empresa;
import com.api.pasajes.models.Micro;
import com.api.pasajes.repositorys.EmpresaRepository;
import com.api.pasajes.repositorys.MicroRepository;
import com.api.pasajes.services.MicroService;

@Service
public class MicroServiceImpl implements MicroService{

    @Autowired
    private MicroRepository microRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public ResponseEntity<Micro> create(Micro micro) {
        return ResponseEntity.ok(microRepository.save(micro));
    }

    @Override
    public List<Micro> getAll() {
        return microRepository.findAll();
    }

    @Override
    public ResponseEntity<Micro> addEmpresa(String nombre, String empresa) {
        Micro microExistente = microRepository.findByNombre(nombre);
        Empresa empresaExistente = empresaRepository.findByNombre(empresa);

        if (microExistente != null && empresaExistente != null) {
            if (!empresaExistente.getMicros().contains(microExistente)) {
                empresaExistente.getMicros().add(microExistente);
                microExistente.setEmpresaMicro(empresaExistente);
                microRepository.save(microExistente);
                return ResponseEntity.ok(microExistente);
            }
        }
        return ResponseEntity.badRequest().build();
    }

}
