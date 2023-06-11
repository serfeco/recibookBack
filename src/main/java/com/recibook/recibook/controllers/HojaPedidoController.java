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

import com.recibook.recibook.entities.HojaPedido;
import com.recibook.recibook.entities.HojaPedidoIngrediente;
import com.recibook.recibook.services.HojaPedidoService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/hojapedido")
public class HojaPedidoController {

    @Autowired
    private HojaPedidoService service;
    
    @PostMapping("/crear")
    public ResponseEntity<HojaPedido> crear(@RequestBody HojaPedido hoja) {
        return ResponseEntity.ok(service.crear(hoja));
    }
    
    @PostMapping("/modificar")
    public ResponseEntity<HojaPedido> modificar(@RequestBody HojaPedido hoja) {
        return ResponseEntity.ok(service.modificar(hoja));
    }
    
    @DeleteMapping("/borrar")
    public ResponseEntity<HttpStatus> borrar(@RequestParam int idHojaPedido) {
    	service.borrar(idHojaPedido);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/admin/listar")
    public ResponseEntity<List<HojaPedido>> listarTodas() {
        return ResponseEntity.ok(service.listaTodas());
    }
    
    @GetMapping("/ver")
    public ResponseEntity<Optional<HojaPedido>> ver(@RequestParam int idHojaPedido) {
        return ResponseEntity.ok(service.verHojaPedido(idHojaPedido));
    }
    
    @PostMapping("/addIngrediente")
    public ResponseEntity<HojaPedidoIngrediente> addIngrediente(@RequestBody HojaPedidoIngrediente ingrediente) {
        return ResponseEntity.ok(service.agregarIngrediente(ingrediente));
    }
    
    @DeleteMapping("/borrarIngrediente")
    public ResponseEntity<String> borrarIngrediente(@RequestParam int idHPIngrediente) {
        service.eliminarIngrediente(idHPIngrediente);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/modificarIngrediente")
    public ResponseEntity<HojaPedidoIngrediente> modificarIngrediente(@RequestBody HojaPedidoIngrediente ingrediente) {
        return ResponseEntity.ok(service.modificarIngrediente(ingrediente));
    }
    
    @GetMapping("/listaIngredientes")
    public ResponseEntity<List<HojaPedidoIngrediente>> listaIngredientes(@RequestParam int idHPIngrediente){
        return ResponseEntity.ok(service.listaIngredientes(idHPIngrediente));
    }
    
    @GetMapping("/verIngrediente")
    public ResponseEntity<Optional<HojaPedidoIngrediente>> verIngrediente(@RequestParam int idHPIngrediente){
        return ResponseEntity.ok(service.verIngrediente(idHPIngrediente));
    }
    
}
