package com.recibook.recibook.entities;
 
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Usuario.
 */
@Entity

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data

/**
 * Instantiates a new usuario.
 *
 * @param dni the dni
 * @param nombre the nombre
 * @param apellidos the apellidos
 * @param email the email
 * @param password the password
 * @param telefono the telefono
 * @param fechaCreacion the fecha creacion
 * @param locales the locales
 * @param recetas the recetas
 * @param escandallos the escandallos
 * @param hojaPedidos the hoja pedidos
 */
@AllArgsConstructor

/**
 * Instantiates a new usuario.
 */
@NoArgsConstructor

@Table(name = "Usuarios")
public class Usuario {

   
    
    /** The dni. */
    @Column(name = "dni", nullable = false, unique = true, length = 9)
    private String dni;
    
    /** The nombre. */
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;
    
    /** The apellidos. */
    @Column(name = "apellidos", nullable = false, length = 40)
    private String apellidos;
    
    /** The email. */
    @Id
    @Column(name = "email", unique = true, nullable = false, length = 40)
    private String email;
    
    /** The password. */
    @Column(name = "password", nullable = false)
    private String password;
    
    /** The telefono. */
    @Column(name = "telefono", nullable = true)
    private String telefono;
    
    /** The fecha creacion. */
    @Column(name = "fechaCreacion")
    private LocalDate fechaCreacion;
    
    /** The locales. */
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Local> locales;
    
    /** The recetas. */
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Receta> recetas;
    
    /** The escandallos. */
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Escandallo> escandallos;
    
    /** The hoja pedidos. */
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<HojaPedido> hojaPedidos;
      
}
