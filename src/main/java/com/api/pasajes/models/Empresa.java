package com.api.pasajes.models;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic
    private String nombre;
    private String cuilCuit;

    @OneToMany(mappedBy = "empresaPasaje")
    private Collection<Pasaje> pasajes;

    @OneToMany
    private Collection<Micro> micros;

    public Empresa() {
    }

    

    public Empresa(String nombre, String cuilCuit) {
        this.nombre = nombre;
        this.cuilCuit = cuilCuit;
        this.pasajes = new ArrayList<>();
        this.micros = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Collection<Pasaje> getPasajes() {
        return pasajes;
    }


    public String getCuilCuit() {
        return cuilCuit;
    }



    public Collection<Micro> getMicros() {
        return micros;
    }

    

    
}
