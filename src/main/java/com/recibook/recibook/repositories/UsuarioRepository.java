package com.recibook.recibook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.recibook.recibook.entities.Usuario;

import jakarta.transaction.Transactional;



public interface UsuarioRepository extends JpaRepository<Usuario, String> {


    // El método inicioSesion sirve para comprobar la contraseña al modificarla
    @Query(nativeQuery = true, value = "SELECT * FROM usuarios WHERE email=:email AND password=:password")
    public Usuario inicioSesion(String email, String password);

   
    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM usuarios WHERE email=:email")
    public Integer emailExiste(String email);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM usuarios WHERE dni=:dni")
    public Integer dniExiste(String dni);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE usuarios SET password=:password WHERE email=:email")
    public void modifyPassword(String email, String password);
    
    
    
   

    

}
