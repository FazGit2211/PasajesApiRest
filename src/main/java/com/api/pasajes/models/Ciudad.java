package com.api.pasajes.models;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic
    private String nombre;
    private String provincia;
    private float distancia;
    private String nombreImagen;

    @OneToMany(mappedBy = "ciudad")
    @JsonManagedReference
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

    public String getNombre() {
        return nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public float getDistancia() {
        return distancia;
    }

    public Collection<Destino> getDestinos() {
        return destinos;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public boolean addDestinos(Destino destino) {
        if (!this.destinos.contains(destino)) {
            this.destinos.add(destino);
            return true;
        }
        return false;
    }
}
