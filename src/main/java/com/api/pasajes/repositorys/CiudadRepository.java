package com.api.pasajes.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pasajes.models.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {
    public Ciudad findByNombre(String nombre);
}
