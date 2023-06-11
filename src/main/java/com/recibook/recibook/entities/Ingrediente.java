package com.recibook.recibook.entities;

import java.util.List; 

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Ingrediente.
 */
@Entity

/**
 * To string.
 *
 * @return the java.lang. string
 */

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data

/**
 * Instantiates a new ingrediente.
 *
 * @param idIngrediente the id ingrediente
 * @param nombreIngrediente the nombre ingrediente
 * @param alergenos the alergenos
 * @param udMedida the ud medida
 * @param recetas the recetas
 * @param escandallos the escandallos
 * @param hojasPedido the hojas pedido
 */

/**
 * Instantiates a new ingrediente.
 *
 * @param idIngrediente the id ingrediente
 * @param nombreIngrediente the nombre ingrediente
 * @param alergenos the alergenos
 * @param udMedida the ud medida
 * @param recetas the recetas
 * @param escandallos the escandallos
 * @param hojasPedido the hojas pedido
 */
@AllArgsConstructor

/**
 * Instantiates a new ingrediente.
 */

/**
 * Instantiates a new ingrediente.
 */
@NoArgsConstructor
@Table(name = "Ingredientes")
public class Ingrediente {

    /** The id ingrediente. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idIngrediente;
    
    /** The nombre ingrediente. */
    @Column(name = "nombreIngrediente", length = 20)
    private String nombreIngrediente;
    
    
    /** The recetas. */
    @JsonIgnore
    @OneToMany(mappedBy = "ingrediente")
    private List<RecetaIngrediente> recetas;
    
    /** The escandallos. */
    @JsonIgnore
    @ManyToMany(mappedBy = "ingrediente")
    private List<EscandalloIngrediente> escandallos;
    
    /** The hojas pedido. */
    @JsonIgnore
    @ManyToMany(mappedBy = "ingrediente")
    private List<HojaPedidoIngrediente> hojaPedido;
    
}
