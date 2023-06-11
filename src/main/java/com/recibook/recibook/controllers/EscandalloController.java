/*
 * 
 */
package com.recibook.recibook.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recibook.recibook.entities.Escandallo;
import com.recibook.recibook.entities.EscandalloIngrediente;
import com.recibook.recibook.services.EscandalloService;

/**
 * The Class EscandalloController.
 */
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/escandallo")
public class EscandalloController {

    /** The service. */
    @Autowired
    private EscandalloService service;
    
    /**
     * Crear.
     *
     * @param escandallo the escandallo
     * @return the response entity
     */
    @PostMapping("/crear")
    public ResponseEntity<Escandallo> crear(@RequestBody Escandallo escandallo) {
        return ResponseEntity.ok(service.crear(escandallo));
    }
    
    /**
     * Modificar.
     *
     * @param escandallo the escandallo
     * @return the response entity
     */
    @PostMapping("/modificar")
    public ResponseEntity<Escandallo> modificar(@RequestBody Escandallo escandallo) {
        return ResponseEntity.ok(service.modificar(escandallo));
    }
    
    /**
     * Borrar.
     *
     * @param idEscandallo the id escandallo
     * @return the response entity
     */
    @DeleteMapping("/borrar")
    public ResponseEntity<HttpStatus> borrar(@RequestParam int idEscandallo) {
    	service.borrar(idEscandallo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    /**
     * Listar todas.
     *
     * @return the response entity
     */
    @GetMapping("/admin/listar")
    public ResponseEntity<List<Escandallo>> listarTodas() {
        return ResponseEntity.ok(service.listaTodos());
    }
    
    /**
     * Ver.
     *
     * @param idEscandallo the id escandallo
     * @return the response entity
     */
    @GetMapping("/ver")
    public ResponseEntity<Optional<Escandallo>> ver(@RequestParam int idEscandallo) {
        return ResponseEntity.ok(service.verEscandallo(idEscandallo));
    }
    
    /**
     * Adds the ingrediente.
     *
     * @param ingrediente the ingrediente
     * @return the response entity
     */
    @PostMapping("/addIngrediente")
    public ResponseEntity<EscandalloIngrediente> addIngrediente(@RequestBody EscandalloIngrediente ingrediente) {
        return ResponseEntity.ok(service.agregarIngrediente(ingrediente));
    }
    
    /**
     * Borrar ingrediente.
     *
     * @param idEscandalloIngrediente the id escandallo ingrediente
     * @return the response entity
     */
    @DeleteMapping("/borrarIngrediente")
    public ResponseEntity<HttpStatus> borrarIngrediente(@RequestParam int idEscandalloIngrediente) {
        service.eliminarIngrediente(idEscandalloIngrediente);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    /**
     * Modificar ingrediente.
     *
     * @param ingrediente the ingrediente
     * @return the response entity
     */
    @PostMapping("/modificarIngrediente")
    public ResponseEntity<EscandalloIngrediente> modificarIngrediente(@RequestBody EscandalloIngrediente ingrediente) {
        return ResponseEntity.ok(service.modificarIngrediente(ingrediente));
    }
    
    /**
     * Lista ingredientes.
     *
     * @param idEscandallo the id escandallo
     * @return the response entity
     */
    @GetMapping("/listaIngredientes")
    public ResponseEntity<List<EscandalloIngrediente>> listaIngredientes(@RequestParam int idEscandallo){
        return ResponseEntity.ok(service.listaIngredientes(idEscandallo));
    }
    
    /**
     * Ver ingrediente.
     *
     * @param idEscandalloIngrediente the id escandallo ingrediente
     * @return the response entity
     */
    @GetMapping("/verIngrediente")
    public ResponseEntity<Optional<EscandalloIngrediente>> verIngrediente(@RequestParam int idEscandalloIngrediente){
        return ResponseEntity.ok(service.verIngrediente(idEscandalloIngrediente));
    }
}
