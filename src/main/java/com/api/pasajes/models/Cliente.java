package com.api.pasajes.models;


import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Persona {

    private String codigo;

    @OneToMany
    @JoinColumn(name = "id_cliente")
    @JsonManagedReference
    private Collection<Pasaje> pasajes;



    public Cliente(String nombre, String apellido, Integer dni, String email) {
        super(nombre, apellido, dni, email);
        this.codigo = String.valueOf(Math.random());
        this.pasajes = new ArrayList<>();
    }

}
