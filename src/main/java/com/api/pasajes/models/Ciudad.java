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

    @OneToMany(mappedBy = "ciudad")
    @JsonManagedReference
    private Collection<Destino> destinos;

    public Ciudad() {
    }

    public Ciudad(String nombre, String provincia, float distancia) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.distancia = distancia;
        this.destinos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public Collection<Destino> getDestinos() {
        return destinos;
    }

    public void setDestinos(Collection<Destino> destinos) {
        this.destinos = destinos;
    }

    public boolean addDestinos(Destino destino) {
        if (!this.destinos.contains(destino)) {
            this.destinos.add(destino);
            return true;
        }
        return false;
    }
}
