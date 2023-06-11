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
 * The Class Receta.
 */
@Entity

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data

/**
 * Instantiates a new receta.
 *
 * @param idReceta the id receta
 * @param imagen the imagen
 * @param nombre the nombre
 * @param cantidad the cantidad
 * @param numRaciones the num raciones
 * @param procedimiento the procedimiento
 * @param observaciones the observaciones
 * @param usuario the usuario
 * @param ingredientes the ingredientes
 */
@AllArgsConstructor

/**
 * Instantiates a new receta.
 */
@NoArgsConstructor

@Table(name = "recetas")
public class Receta {

    /** The id receta. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idReceta;

    /** The imagen. */
    @Column(name = "imagen")
    private String imagen;

    /** The nombre. */
    @Column(name = "nombre")
    private String nombre;

    /** The num raciones. */
    @Column(name = "num_raciones")
    private int numRaciones;

    /** The procedimiento. */
    @Column(name = "procedimiento")
    private String procedimiento;

    /** The observaciones. */
    @Column(name = "observaciones")
    private String observaciones;

    /** The usuario. */
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<RecetaIngrediente> recetaIngrediente = new ArrayList<>();
     
    
    
    
}
