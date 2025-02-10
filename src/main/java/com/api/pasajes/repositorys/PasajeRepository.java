package com.api.pasajes.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pasajes.models.Pasaje;

public interface PasajeRepository extends JpaRepository<Pasaje, Integer> {

}
