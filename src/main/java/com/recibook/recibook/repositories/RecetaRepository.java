package com.recibook.recibook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.recibook.recibook.entities.Receta;

public interface RecetaRepository extends JpaRepository<Receta, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM recetas WHERE nombre LIKE %:nombreReceta%")
    public List<Receta> buscarReceta(String nombreReceta);
}
