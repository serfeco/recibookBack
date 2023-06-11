package com.recibook.recibook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recibook.recibook.entities.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM INGREDIENTES WHERE NOMBRE_INGREDIENTE LIKE %:nombreIngrediente%")
    public List<Ingrediente> getIngrediente(String nombreIngrediente);

}
