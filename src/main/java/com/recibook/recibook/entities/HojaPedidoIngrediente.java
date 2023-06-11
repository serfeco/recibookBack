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

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "HojaPedidoIngrediente")
public class HojaPedidoIngrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "idHojaPedido")
    private HojaPedido hojaPedido;

    @ManyToOne
    @JoinColumn(name = "idIngrediente")
    private Ingrediente ingrediente;
    
    @Column(name = "precioUnitario")
    private float precioUnitario;
    
    @Column(name = "precioTotal")
    private float precioTotal;

    @Column(name = "cantidad")
    private float cantidad;
    
    @Column(name = "udMedida")
    private String udMedida;
}
