package com.recibook.recibook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recibook.recibook.entities.RecetaIngrediente;

public interface RecetaIngredienteRepository extends JpaRepository<RecetaIngrediente, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM RECETA_INGREDIENTE WHERE id_receta =:idReceta")
    public List<RecetaIngrediente> listaIngredientes( int idReceta);
    
   @Query(nativeQuery = true, value = "SELECT * FROM RECETA_INGREDIENTE WHERE id_receta =:idReceta AND id_ingrediente=:idIngrediente")
   public List<RecetaIngrediente> comprobarIngrediente(int idReceta, int idIngrediente);
}
