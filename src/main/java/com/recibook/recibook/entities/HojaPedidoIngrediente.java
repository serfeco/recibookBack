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
@Table(name = "hoja_pedido_ingrediente")
public class HojaPedidoIngrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_hoja_pedido")
    private HojaPedido hojaPedido;

    @ManyToOne
    @JoinColumn(name = "id_ingrediente")
    private Ingrediente ingrediente;
    
    @Column(name = "precio_unitario")
    private float precioUnitario;
    
    @Column(name = "precio_total")
    private float precioTotal;

    @Column(name = "cantidad")
    private float cantidad;
    
    @Column(name = "ud_medida")
    private String udMedida;
}
