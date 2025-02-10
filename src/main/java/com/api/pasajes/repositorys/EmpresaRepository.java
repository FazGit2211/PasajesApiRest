package com.api.pasajes.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pasajes.models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    Empresa findByNombre(String nombre);
}
