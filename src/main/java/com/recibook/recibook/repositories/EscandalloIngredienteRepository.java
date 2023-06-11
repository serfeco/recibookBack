package com.recibook.recibook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recibook.recibook.entities.EscandalloIngrediente;

public interface EscandalloIngredienteRepository extends JpaRepository<EscandalloIngrediente, Integer>{

    @Query(nativeQuery = true, value = "SELECT * FROM ESCANDALLO_INGREDIENTE WHERE id_escandallo =:idEscandallo")
    public List<EscandalloIngrediente> listaIngredientes( int idEscandallo);
    
   @Query(nativeQuery = true, value = "SELECT * FROM ESCANDALLO_INGREDIENTE WHERE id_escandallo =:idEscandallo AND id_ingrediente=:idIngrediente")
   public List<EscandalloIngrediente> comprobarIngrediente(int idEscandallo, int idIngrediente);

}
