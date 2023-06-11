package com.recibook.recibook.entities; 

import java.util.ArrayList;   
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Escandallo.
 */
@Entity

/**
 * Instantiates a new escandallo.
 *
 * @param idEscandallo the id escandallo
 * @param nombre the nombre
 * @param numRaciones the num raciones
 * @param cantidad the cantidad
 * @param coste the coste
 * @param precioKg the precio kg
 * @param precioRacion the precio racion
 * @param usuario the usuario
 * @param ingredientes the ingredientes
 */
@AllArgsConstructor

/**
 * Instantiates a new escandallo.
 */
@NoArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data
@Table(name = "escandallos")
public class Escandallo {

    /** The id escandallo. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEscandallo;
    
    /** The nombre. */
    @Column(name = "nombre")
    private String nombre;
    
    /** The num raciones. */
    @Column(name = "num_raciones")
    private int numRaciones;
    
    /** The coste. */
    @Column(name = "coste")
    private float coste;
    
    /** The usuario. */
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    /** The ingredientes. */
    @OneToMany(mappedBy = "escandallo", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<EscandalloIngrediente> escandalloIngrediente = new ArrayList<>();
    
}
