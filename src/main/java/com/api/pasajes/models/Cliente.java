package com.api.pasajes.models;


import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Cliente extends Persona {

    private String codigo;

    @OneToMany
    private Collection<Pasaje> pasajes;

    public Cliente(String nombre, String apellido, Integer dni, String email) {
        super(nombre, apellido, dni, email);
        this.codigo = String.valueOf(Math.random());
        this.pasajes = new ArrayList<>();
    }

}
