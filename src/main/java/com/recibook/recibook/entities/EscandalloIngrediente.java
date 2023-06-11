package com.recibook.recibook.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Escandallo_Ingrediente")
public class EscandalloIngrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "idEscandallo")
    @JsonBackReference
    private Escandallo escandallo;

    @ManyToOne
    @JoinColumn(name = "idIngrediente")
    private Ingrediente ingrediente;

    @Column(name = "cantidad")
    private float cantidad;
    
   
    @Column(name = "precioKg")
    private float precioKg;
    
   
    @Column(name = "precioRacion")
    private float precioRacion;
    
    @Column(name = "udMedida")
    private String udMedida;
}
