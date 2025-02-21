package com.api.pasajes.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.api.pasajes.models.Micro;

public interface MicroService {

    ResponseEntity<Micro> create(Micro micro);
    List<Micro> getAll();
}
