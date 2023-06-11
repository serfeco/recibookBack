package com.recibook.recibook.controllers;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recibook.recibook.entities.Receta;
import com.recibook.recibook.entities.RecetaIngrediente;
import com.recibook.recibook.services.RecetaService;

/**
 * The Class RecetaController.
 */
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/receta")
public class RecetaController {

    /** The service. */
    @Autowired
    private RecetaService service;

    /**
     * Crear.
     *
     * @param receta the receta
     * @return the response entity
     */
    @PostMapping("/crear")
    public ResponseEntity<Receta> crear(@RequestBody Receta receta) {
        return ResponseEntity.ok(service.crear(receta));
    }

    /**
     * Modificar.
     *
     * @param receta the receta
     * @return the response entity
     */
    @PostMapping("/modificar")
    public ResponseEntity<Receta> modificar(@RequestBody Receta receta) {
        return ResponseEntity.ok(service.modificar(receta));
    }
    
//    @PostMapping("guardarImg")
//    public ResponseEntity<Receta> guardarImg(@RequestBody MultipartFile img, @RequestParam int idReceta){
//        return ResponseEntity.ok(service.guardarImg(img, idReceta));
//    }

    /**
     * Borrar.
     *
     * @param idReceta the id receta
     * @return the response entity
     */
    @DeleteMapping("/borrar")
    public ResponseEntity<HttpStatus> borrar(@RequestParam int idReceta) {
        service.borrar(idReceta);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Listar todas.
     *
     * @return the response entity
     */
    @GetMapping("/admin/listar")
    public ResponseEntity<List<Receta>> listarTodas() {
        return ResponseEntity.ok(service.listaTodas());
    }

    /**
     * Buscar.
     *
     * @param nombreReceta the nombre receta
     * @return the response entity
     */
    @GetMapping("/buscar")
    public ResponseEntity<List<Receta>> buscar(@RequestParam String nombreReceta) {
        return ResponseEntity.ok(service.buscarReceta(nombreReceta));
    }

    /**
     * Ver.
     *
     * @param idReceta the id receta
     * @return the response entity
     */
    @GetMapping("/ver")
    public ResponseEntity<Optional<Receta>> ver(@RequestParam int idReceta) {
        return ResponseEntity.ok(service.verReceta(idReceta));
    }

    /**
     * Adds the ingrediente.
     *
     * @param ingrediente the ingrediente
     * @return the response entity
     */
    @PostMapping("/addIngrediente")
    public ResponseEntity<RecetaIngrediente> addIngrediente( @Validated @RequestBody RecetaIngrediente ingrediente) {
        return ResponseEntity.ok(service.agregarIngrediente(ingrediente));
    }

    /**
     * Borrar ingrediente.
     *
     * @param idRecetaIngrediente the id receta ingrediente
     * @return the response entity
     */
    @DeleteMapping("/borrarIngrediente")
    public ResponseEntity<HttpStatus> borrarIngrediente(@RequestParam int idRecetaIngrediente) {
        service.eliminarIngrediente(idRecetaIngrediente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Modificar ingrediente.
     *
     * @param ingrediente the ingrediente
     * @return the response entity
     */
    @PostMapping("/modificarIngrediente")
    public ResponseEntity<RecetaIngrediente> modificarIngrediente(@RequestBody RecetaIngrediente ingrediente) {
        return ResponseEntity.ok(service.modificarIngrediente(ingrediente));
    }
    
    /**
     * Lista ingredientes.
     *
     * @param idReceta the id receta
     * @return the response entity
     */
    @GetMapping("/listaIngredientes")
    public ResponseEntity<List<RecetaIngrediente>> listaIngredientes(@RequestParam int idReceta){
        return ResponseEntity.ok(service.listaIngredientes(idReceta));
    }
    
    /**
     * Ver ingrediente.
     *
     * @param idRecetaIngrediente the id receta ingrediente
     * @return the response entity
     */
    @GetMapping("/verIngrediente")
    public ResponseEntity<Optional<RecetaIngrediente>> verIngrediente(@RequestParam int idRecetaIngrediente){
        return ResponseEntity.ok(service.verIngrediente(idRecetaIngrediente));
    }

}
