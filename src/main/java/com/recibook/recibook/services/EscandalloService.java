package com.recibook.recibook.services;

import java.util.List;  
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.recibook.recibook.entities.Escandallo;
import com.recibook.recibook.entities.EscandalloIngrediente;
import com.recibook.recibook.exceptions.Excepcion;
import com.recibook.recibook.repositories.EscandalloIngredienteRepository;
import com.recibook.recibook.repositories.EscandalloRepository;

/**
 * The Class EscandalloService.
 */
@Service
public class EscandalloService {

    /** The repo. */
    @Autowired
    private EscandalloRepository repo;
    
    /** The repo escandallo ingrediente. */
    @Autowired
    private EscandalloIngredienteRepository repoEscandalloIngrediente;
    
    /**
     * Crear.
     *
     * @param escandallo the escandallo
     * @return the escandallo
     */
    public Escandallo crear(Escandallo escandallo)  {
        int id = repo.save(escandallo).getIdEscandallo();
        repo.findById(escandallo.getIdEscandallo());
        for (EscandalloIngrediente escandalloIngrediente : escandallo.getEscandalloIngrediente()) {
            if (repoEscandalloIngrediente.comprobarIngrediente(escandalloIngrediente.getEscandallo().getIdEscandallo(),
                    escandalloIngrediente.getIngrediente().getIdIngrediente()).isEmpty()) {
                escandalloIngrediente.getEscandallo().setIdEscandallo(id);
                agregarIngrediente(escandalloIngrediente);
            }

           
        }
        return escandallo;
    }
    
    /**
     * Modificar.
     *
     * @param escandallo the escandallo
     * @return the escandallo
     */
    public Escandallo modificar(Escandallo escandallo) {
        repo.save(escandallo);
         for(EscandalloIngrediente escandalloIngrediente:escandallo.getEscandalloIngrediente()) {
             if(repoEscandalloIngrediente.comprobarIngrediente(escandalloIngrediente.getEscandallo().getIdEscandallo(), escandalloIngrediente.getIngrediente().getIdIngrediente()).isEmpty()) {
                 escandalloIngrediente.getEscandallo().setIdEscandallo(escandallo.getIdEscandallo());
                 agregarIngrediente(escandalloIngrediente);
             }

         }
        
         return escandallo;  
         
     }
    
    /**
     * Borrar.
     *
     * @param idEscandallo the id escandallo
     * @return the string
     */
    public String borrar(int idEscandallo) {
        repo.deleteById(idEscandallo);
        return "Escandallo eliminado correctamente";
    }
    
    /**
     * Lista todos.
     *
     * @return the list
     */
    public List<Escandallo> listaTodos() {
        if (repo.findAll().isEmpty()) {
            throw new Excepcion(HttpStatus.NO_CONTENT, "No se han encontrado escandallos");
        }
        return repo.findAll();
    }
    
    /**
     * Ver receta.
     *
     * @param idEscandallo the id escandallo
     * @return the optional
     */
    public Optional<Escandallo> verEscandallo(int idEscandallo) {
        return repo.findById(idEscandallo);
    }
    

    /**
     * Agregar ingrediente.
     *
     * @param ingrediente the ingrediente
     * @return the escandallo ingrediente
     */
    public EscandalloIngrediente agregarIngrediente(EscandalloIngrediente ingrediente) {
        return repoEscandalloIngrediente.save(ingrediente); 
     }
    
    /**
     * Eliminar ingrediente.
     *
     * @param idEscandalloIngrediente the id escandallo ingrediente
     */
    public void eliminarIngrediente(int idEscandalloIngrediente) {
        repoEscandalloIngrediente.deleteById(idEscandalloIngrediente);
    }
    
    /**
     * Modificar ingrediente.
     *
     * @param ingrediente the ingrediente
     * @return the escandallo ingrediente
     */
    public EscandalloIngrediente modificarIngrediente(EscandalloIngrediente ingrediente) {
        return repoEscandalloIngrediente.save(ingrediente);
    }
    
    /**
     * Lista ingredientes.
     *
     * @param idEscandallo the id escandallo
     * @return the list
     */
    public List<EscandalloIngrediente> listaIngredientes(int idEscandallo){
        return repoEscandalloIngrediente.listaIngredientes(idEscandallo);
    }
    
    /**
     * Ver ingrediente.
     *
     * @param idEscandalloIngrediente the id escandallo ingrediente
     * @return the optional
     */
    public Optional<EscandalloIngrediente> verIngrediente(int idEscandalloIngrediente) {
        return repoEscandalloIngrediente.findById(idEscandalloIngrediente);
    }
    
}
