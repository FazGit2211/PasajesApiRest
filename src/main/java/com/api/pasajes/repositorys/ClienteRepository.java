package com.api.pasajes.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pasajes.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    public Cliente findByDni(Integer dni);
    public Cliente findByNombre(String nombre);
}
