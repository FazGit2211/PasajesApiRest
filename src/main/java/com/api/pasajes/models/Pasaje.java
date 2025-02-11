package com.api.pasajes.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Pasaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private String numero;

    private String formaPago;

    private float valor;

    @Temporal(value = TemporalType.DATE)
    private Date fecha;

    @OneToOne
    @JoinColumn(name = "id_destino")
    private Destino destino;

    @ManyToOne
    @JsonBackReference
    private Cliente cliente;

    @ManyToOne
    private Empresa empresa;

    public Pasaje() {
    }

    public Pasaje(String pago, float valor, Destino destino) {
        this.numero = String.valueOf(Math.random());
        this.formaPago = pago;
        this.valor = valor;
        this.destino = destino;
    }

}
