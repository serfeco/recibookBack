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

import com.recibook.recibook.entities.Local;
import com.recibook.recibook.services.LocalService;

/**
 * The Class LocalController.
 */
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/local")
public class LocalController {

    /** The service. */
    @Autowired
    private LocalService service;

    /**
     * Crear local.
     *
     * @param local the local
     * @return the response entity
     */
    @PostMapping("/crear")
    public ResponseEntity<Local> crearLocal(@Validated @RequestBody Local local) {
        return ResponseEntity.ok(service.crearLocal(local));
    }

    /**
     * Modificar local.
     *
     * @param local the local
     * @return the response entity
     */
    @PostMapping("/modificar")
    public ResponseEntity<Local> modificarLocal(@Validated @RequestBody Local local) {
        return ResponseEntity.ok(service.modificarLocal(local));
    }

    

    /**
     * Ver local.
     *
     * @param idLocal the id local
     * @return the response entity
     */
    @GetMapping("/ver")
    public ResponseEntity<Optional<Local>> verLocal(@RequestParam int idLocal) {
        return ResponseEntity.ok(service.verLocal(idLocal));
    }

    /**
     * Borrar local.
     *
     * @param idLocal the id local
     * @return the response entity
     */
    @DeleteMapping("/borrar")
    public ResponseEntity<HttpStatus> borrarLocal(@RequestParam int idLocal) {
        service.borrarLocal(idLocal);
        return new ResponseEntity<>(HttpStatus.OK);
    }
 
    /**
     * Listar local.
     *
     * @return the response entity
     */
    @GetMapping("/admin/lista")
    public ResponseEntity<List<Local>> listarLocal() {
        return ResponseEntity.ok(service.listaLocal());
    }
}
