package com.recibook.recibook.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
 * The Class Local.
 */
@Entity

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data

/**
 * Instantiates a new local.
 *
 * @param idLocal the id local
 * @param cif the cif
 * @param nombreLocal the nombre local
 * @param direccion the direccion
 * @param email the email
 * @param telefono the telefono
 * @param usuario the usuario
 * @param hojaPedido the hoja pedido
 */
@AllArgsConstructor

/**
 * Instantiates a new local.
 */
@NoArgsConstructor

@Table(name = "locales")
public class Local {

    /** The id local. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idLocal;
    
    /** The cif. */
    @Column(name = "cif", nullable = false, length = 9)
    private String cif;
    
    /** The nombre local. */
    @Column(name = "nombre_local", nullable = false, length = 40)
    private String nombreLocal;
    
    /** The direccion. */
    @Column(name = "direccion", nullable = false, length = 40)
    private String direccion;
    
    /** The email. */
    @Column(name = "email", nullable = false, length = 40)
    private String email;
    
    /** The telefono. */
    @Column(name = "telefono", nullable = false, length = 13)
    private String telefono;
    
    /** The usuario. */
    @ManyToOne
    @JoinColumn(name = "usuario", nullable = false)
    private Usuario usuario;
    
    /** The hoja pedido. */
    @JsonIgnore
    @OneToMany(mappedBy = "local")
    private List<HojaPedido> hojaPedido;
    
    
}