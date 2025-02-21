package com.api.pasajes.services.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.api.pasajes.models.Micro;
import com.api.pasajes.repositorys.MicroRepository;
import com.api.pasajes.services.MicroService;

@Service
public class MicroServiceImpl implements MicroService{

    @Autowired
    private MicroRepository microRepository;

    @Override
    public ResponseEntity<Micro> create(Micro micro) {
        return ResponseEntity.ok(microRepository.save(micro));
    }

    @Override
    public List<Micro> getAll() {
        return microRepository.findAll();
    }

}
