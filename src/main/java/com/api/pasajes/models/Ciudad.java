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
import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic
    private String nombre;
    private String provincia;
    private float distancia;
    private String nombreImagen;

    @OneToMany
    private Collection<Destino> destinos;

    public Ciudad() {
    }

    public Ciudad(String nombre, String provincia, float distancia, String nom) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.distancia = distancia;
        this.destinos = new ArrayList<>();
        this.nombreImagen = nom;
    }


    public boolean addDestinos(Destino destino) {
        if (!this.destinos.contains(destino)) {
            this.destinos.add(destino);
            return true;
        }
        return false;
    }
}
