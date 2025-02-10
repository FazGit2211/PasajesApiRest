package com.api.pasajes.models;

import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic
    private String nombre;
    private String cuil_cuit;

    @OneToMany
    private Collection<Pasaje> pasajes;

    public Empresa() {
    }

    public Empresa(String nombre, String numero) {
        this.nombre = nombre;
        this.cuil_cuit = numero;
    }

    public void addPasajeCollection(Pasaje pasaje) {
        if (!this.pasajes.contains(pasaje)) {
            this.pasajes.add(pasaje);
        }
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCuil_cuit() {
        return cuil_cuit;
    }

    public Collection<Pasaje> getPasajes() {
        return pasajes;
    }

}
