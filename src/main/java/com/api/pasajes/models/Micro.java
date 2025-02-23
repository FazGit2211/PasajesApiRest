package com.api.pasajes.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Micro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String tipo;
    private Integer asientos = 0;
    private final Integer MAX_ASIENTOS = 15;
    
    @OneToOne
    private Ciudad estacion;

    @ManyToOne(targetEntity = Empresa.class)
    private Empresa empresaMicro;

    public Micro(){};

    public Micro(String tipo,String nombre, Ciudad ciudad){
        this.tipo = tipo;
        this.nombre = nombre;
        this.estacion = ciudad;
    }
    

}
