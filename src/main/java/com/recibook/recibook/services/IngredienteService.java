package com.recibook.recibook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recibook.recibook.entities.Ingrediente;
import com.recibook.recibook.repositories.IngredienteRepository;

/**
 * The Class IngredienteService.
 */
@Service
public class IngredienteService {

    /** The repo. */
    @Autowired
    private IngredienteRepository repo;

    /**
     * Lista ingrediente.
     *
     * @return the list
     */
    public List<Ingrediente> listaIngrediente() {
        return repo.findAll();
    }

    /**
     * Buscar ingrediente.
     *
     * @param nombreIngrediente the nombre ingrediente
     * @return the list
     */
    public List<Ingrediente> buscarIngrediente(String nombreIngrediente) {
        return repo.getIngrediente(nombreIngrediente);
    }

    /**
     * Seleccionar ingrediente.
     *
     * @param idIngrediente the id ingrediente
     * @return the optional
     */
    public Optional<Ingrediente> seleccionarIngrediente(int idIngrediente) {
        return repo.findById(idIngrediente);
    }

    // ---------------ADMIN---------------------

    /**
     * Crear ingrediente.
     *
     * @param ingrediente the ingrediente
     * @return the string
     */
    public String crearIngrediente(Ingrediente ingrediente) {
        repo.save(ingrediente);
        return "Ingrediente agregado correctamente!";
    }

    /**
     * Eliminar ingrediente.
     *
     * @param idIngrediente the id ingrediente
     * @return the string
     */
    public String eliminarIngrediente(int idIngrediente) {
        repo.deleteById(idIngrediente);
        return "Ingrediente eliminado con éxito!";
    }

    /**
     * Modificar ingrediente.
     *
     * @param ingrediente the ingrediente
     * @return the ingrediente
     */
    public Ingrediente modificarIngrediente(Ingrediente ingrediente) {
        return repo.save(ingrediente);
    }

}
