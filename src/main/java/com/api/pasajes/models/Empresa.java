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
    private String cuilCuit;

    @OneToMany
    private Collection<Pasaje> pasajes;

    public Empresa() {
    }

    

    public Empresa(String nombre, String cuilCuit) {
        this.nombre = nombre;
        this.cuilCuit = cuilCuit;
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

    
}
