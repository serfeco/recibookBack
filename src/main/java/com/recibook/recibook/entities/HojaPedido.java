package com.recibook.recibook.entities;
 
import java.time.LocalDate;  
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
 * The Class HojaPedido.
 */
@Entity

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data

/**
 * Instantiates a new hoja pedido.
 *
 * @param idHojaPedido the id hoja pedido
 * @param emailProveedor the email proveedor
 * @param fechaPedido the fecha pedido
 * @param fechaEntrega the fecha entrega
 * @param precioUnitario the precio unitario
 * @param precioTotal the precio total
 * @param completado the completado
 * @param usuario the usuario
 * @param local the local
 * @param ingredientes the ingredientes
 */
@AllArgsConstructor

/**
 * Instantiates a new hoja pedido.
 */
@NoArgsConstructor
@Table(name = "HojasPedido")
public class HojaPedido {

    /** The id hoja pedido. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int idHojaPedido;
    
    /** The email proveedor. */
    @Column(name = "emailProveedor")
    private String emailProveedor;
    
    /** The fecha pedido. */
    @Column(name = "fechaPedido")
    private LocalDate fechaPedido;
    
    /** The fecha entrega. */
    @Column(name = "fechaEntrega")
    private LocalDate fechaEntrega;
    
    /** The completado. */
    @Column(name = "completado")
    private boolean completado;
    
    /** The usuario. */
    @ManyToOne
    @JoinColumn(name = "id_Usuario")
    private Usuario usuario;
    
    /** The local. */
    @ManyToOne
    @JoinColumn(name = "id_Local")
    private Local local;
    
    /** The ingredientes. */
    @OneToMany(mappedBy = "hojaPedido", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<HojaPedidoIngrediente> hojaPedidoIngrediente;
    
    
}
