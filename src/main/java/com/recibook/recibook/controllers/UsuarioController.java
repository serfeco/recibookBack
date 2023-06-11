package com.recibook.recibook.controllers;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recibook.recibook.entities.Escandallo;
import com.recibook.recibook.entities.HojaPedido;
import com.recibook.recibook.entities.Local;
import com.recibook.recibook.entities.Receta;
import com.recibook.recibook.entities.Usuario;
import com.recibook.recibook.services.UsuarioService;

/**
 * The Class UsuarioController.
 */
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/usuario")
public class UsuarioController {

    /** The service. */
    @Autowired
    private UsuarioService service;
    
   
    /**
     * Iniciar sesion.
     *
     * @param email the email
     * @param password the password
     * @return the response entity
     */
    //Método para confirmar password
    @GetMapping("/login")
    public ResponseEntity<Usuario> iniciarSesion(@RequestParam String email, @RequestParam String password) {
        return ResponseEntity.ok(service.iniciarSesion(email, password));
    }
    
    /**
     * Check email.
     *
     * @param email the email
     * @return the response entity
     */
    @GetMapping("/checkEmail")
    public ResponseEntity<Integer> checkEmail(@RequestParam String email) {
        return ResponseEntity.ok(service.checkEmail(email));
    }
    
    /**
     * Check dni.
     *
     * @param dni the dni
     * @return the response entity
     */
    @GetMapping("/checkDni")
    public ResponseEntity<Integer> checkDni(@RequestParam String dni) {
        return ResponseEntity.ok(service.checkDni(dni));
    }
    
    /**
     * Registro.
     *
     * @param usuario the usuario
     * @return the response entity
     * @throws Exception the exception
     */
    @PostMapping("/registro")
    public ResponseEntity<Usuario> registro(@Validated @RequestBody Usuario usuario) throws Exception {
        return ResponseEntity.ok(service.registro(usuario));
    }
    
    /**
     * Modificar.
     *
     * @param usuario the usuario
     * @return the response entity
     * @throws Exception the exception
     */
    @PostMapping("/modificar")
    public ResponseEntity<Usuario> modificar(@Validated @RequestBody Usuario usuario) throws Exception {
        return ResponseEntity.ok(service.modificarUsuario(usuario));
    }
    
    /**
     * Modificar password.
     *
     * @param email the email
     * @param password the password
     * @return the response entity
     */
    @PostMapping("/modificarPassword")
    public ResponseEntity<String> modificarPassword(@RequestParam String email, @RequestParam String password){
        service.modificarPassword(email, password);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    /**
     * Locales usuario.
     *
     * @param email the email
     * @return the response entity
     */
    @GetMapping("/localesUsuario")
    public ResponseEntity<List<Local>> localesUsuario(@RequestParam String email){
        return ResponseEntity.ok(service.localesUsuario(email));
    }
    
    /**
     * Recetas usuario.
     *
     * @param email the email
     * @return the response entity
     */
    @GetMapping("/recetasUsuario")
    public ResponseEntity<List<Receta>> recetasUsuario(@RequestParam String email){
        return ResponseEntity.ok(service.recetasUsuario(email));
    }
    
    /**
     * Escandallo usuario.
     *
     * @param email the email
     * @return the response entity
     */
    @GetMapping("/escandallosUsuario")
    public ResponseEntity<List<Escandallo>> escandalloUsuario(@RequestParam String email){
        return ResponseEntity.ok(service.escandallosUsuario(email));
    }
    
    /**
     * Hojas pedido usuario.
     *
     * @param email the email
     * @return the response entity
     */
    @GetMapping("/hojasPedidoUsuario")
    public ResponseEntity<List<HojaPedido>> hojasPedidoUsuario(@RequestParam String email){
        return ResponseEntity.ok(service.hojaPedidoUsuario(email));
    }
    
    //--------CONTROLLER ADMINISTRADOR----------------
    
    /**
     * Modificar admin.
     *
     * @param usuario the usuario
     * @return the response entity
     * @throws Exception the exception
     */
    @PostMapping("/admin/modificar")
    public ResponseEntity<Usuario> modificarAdmin(@Validated @RequestBody Usuario usuario) throws Exception {
        return ResponseEntity.ok(service.modificarUsuarioAdmin(usuario));
    }
    
    /**
     * Lista usuario.
     *
     * @return the response entity
     */
    @GetMapping("/admin/listaUsuario")
    public ResponseEntity<List<Usuario>> listaUsuario(){
        return ResponseEntity.ok(service.listaUsuario());
    }
    
    /**
     * Buscar usuario.
     *
     * @param email the email
     * @return the response entity
     */
    @GetMapping("/admin/buscarUsuario")
    public ResponseEntity<Optional<Usuario>> buscarUsuario(@RequestParam String email){
        return ResponseEntity.ok(service.buscarUsuario(email));
    }
    
}
