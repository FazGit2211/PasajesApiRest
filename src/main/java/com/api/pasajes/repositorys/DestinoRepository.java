package com.api.pasajes.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pasajes.models.Destino;

public interface DestinoRepository extends JpaRepository<Destino, Integer> {

}
