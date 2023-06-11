package com.recibook.recibook.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recibook.recibook.entities.Ingrediente;
import com.recibook.recibook.services.IngredienteService;


/**
 * The Class IngredienteController.
 */
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/ingrediente")
public class IngredienteController {

    /** The service. */
    @Autowired
    private IngredienteService service;

    /**
     * Lista ingrediente.
     *
     * @return the response entity
     */
    @GetMapping("/lista")
    public ResponseEntity<List<Ingrediente>> listaIngrediente() {
        return ResponseEntity.ok(service.listaIngrediente());
    }

    /**
     * Buscar ingrediente.
     *
     * @param nombreIngrediente the nombre ingrediente
     * @return the response entity
     */
    @GetMapping("/buscar")
    public ResponseEntity<List<Ingrediente>> buscarIngrediente(@RequestParam String nombreIngrediente) {
        return ResponseEntity.ok(service.buscarIngrediente(nombreIngrediente));
    }

    /**
     * Seleccionar ingrediente.
     *
     * @param idIngrediente the id ingrediente
     * @return the response entity
     */
    @GetMapping("/seleccionar")
    public ResponseEntity<Optional<Ingrediente>> seleccionarIngrediente(@RequestParam int idIngrediente) {
        return ResponseEntity.ok(service.seleccionarIngrediente(idIngrediente));
    }

    // --------------------ADMIN--------------------------

    /**
     * Crear ingrediente.
     *
     * @param ingrediente the ingrediente
     * @return the response entity
     */
    @PostMapping("/admin/crear")
    public ResponseEntity<String> crearIngrediente(@RequestBody Ingrediente ingrediente) {
        return ResponseEntity.ok(service.crearIngrediente(ingrediente));
    }

    /**
     * Modificar ingrediente.
     *
     * @param ingrediente the ingrediente
     * @return the response entity
     */
    @PostMapping("/admin/modificar")
    public ResponseEntity<Ingrediente> modificarIngrediente(@RequestBody Ingrediente ingrediente) {
        return ResponseEntity.ok(service.modificarIngrediente(ingrediente));
    }

    /**
     * Eliminar ingrediente.
     *
     * @param idIngrediente the id ingrediente
     * @return the response entity
     */
    @DeleteMapping("/admin/eliminar")
    public ResponseEntity<String> eliminarIngrediente(@RequestParam int idIngrediente) {
        return ResponseEntity.ok(service.eliminarIngrediente(idIngrediente));
    }

}
