package com.recibook.recibook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.recibook.recibook.entities.Local;
import com.recibook.recibook.exceptions.Excepcion;
import com.recibook.recibook.models.LocalModel;
import com.recibook.recibook.repositories.LocalRepository;

/**
 * The Class LocalService.
 */
@Service
public class LocalService {

    /** The repo. */
    @Autowired
    private LocalRepository repo;
    
    /** The model. */
    @Autowired
    private LocalModel model;
    
    /**
     * Crear local.
     *
     * @param local the local
     * @return the local
     */
    public Local crearLocal(Local local) {
        model.validarCif(local.getCif());
        model.telefonoIncorrecto(local.getTelefono());
        return repo.save(local);
    }
    
    /**
     * Modificar local.
     *
     * @param local the local
     * @return the local
     */
    public Local modificarLocal(Local local) {
        model.telefonoIncorrecto(local.getTelefono());
        return repo.save(local);
    }
    
    /**
     * Ver local.
     *
     * @param idLocal the id local
     * @return the optional
     */
    public Optional<Local> verLocal(int idLocal) {
        return repo.findById(idLocal);
    }
    
    /**
     * Borrar local.
     *
     * @param idLocal the id local
     * @return the string
     */
    public void borrarLocal(int idLocal) {
        repo.deleteById(idLocal);
    }
    
    /**
     * Lista local.
     *
     * @return the list
     */
    //----------------ADMIN----------------------
    public List<Local> listaLocal(){
        if (repo.findAll().isEmpty()) {
            throw new Excepcion(HttpStatus.NO_CONTENT, "Todavia no se han creado locales");
        }
        return repo.findAll();
    }
    
    
    
   
   
}
