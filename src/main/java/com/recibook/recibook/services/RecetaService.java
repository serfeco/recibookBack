package com.recibook.recibook.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import com.recibook.recibook.entities.Receta;
import com.recibook.recibook.entities.RecetaIngrediente;
import com.recibook.recibook.exceptions.Excepcion;
import com.recibook.recibook.repositories.RecetaIngredienteRepository;
import com.recibook.recibook.repositories.RecetaRepository;

/**
 * The Class RecetaService.
 */
@Service
public class RecetaService {

    /** The repo. */
    @Autowired
    private RecetaRepository repo;

    /** The repo receta ingrediente. */
    @Autowired
    private RecetaIngredienteRepository repoRecetaIngrediente;

    /**
     * Crear.
     *
     * @param receta
     *            the receta
     * @return the receta
     */
    public Receta crear(Receta receta) {
        int id = repo.save(receta).getIdReceta();
        repo.findById(receta.getIdReceta());
        for (RecetaIngrediente recetaIngrediente : receta.getRecetaIngrediente()) {
            if (repoRecetaIngrediente.comprobarIngrediente(recetaIngrediente.getReceta().getIdReceta(),
                    recetaIngrediente.getIngrediente().getIdIngrediente()).isEmpty()) {
                recetaIngrediente.getReceta().setIdReceta(id);
                agregarIngrediente(recetaIngrediente);
            }

           
        }
        return receta;
    }

//    public Receta guardarImg(MultipartFile img, int idReceta) {
//
//        Receta receta = repo.findById(idReceta).get();
//
//        if (img != null) {
//            Path directorio = Paths.get("/src/main/resources/images");
//            String rutaAbsoluta = directorio.toFile().getAbsolutePath();
//
//            byte[] byteImg;
//            try {
//                byteImg = img.getBytes();
//                Path rutaCompleta = Paths.get(rutaAbsoluta + "/" + idReceta + img.getOriginalFilename());
//                Files.write(rutaCompleta, byteImg);
//                receta.setImagen(idReceta + img.getOriginalFilename());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return repo.save(receta);
//    }

    /**
     * Modificar.
     *
     * @param receta
     *            the receta
     * @return the receta
     */
    public Receta modificar(Receta receta) {
        repo.save(receta);
        for (RecetaIngrediente recetaIngrediente : receta.getRecetaIngrediente()) {
            if (repoRecetaIngrediente.comprobarIngrediente(recetaIngrediente.getReceta().getIdReceta(),
                    recetaIngrediente.getIngrediente().getIdIngrediente()).isEmpty()) {
                recetaIngrediente.getReceta().setIdReceta(receta.getIdReceta());
                agregarIngrediente(recetaIngrediente);
            }

        }

        return receta;
    }

    /**
     * Borrar.
     *
     * @param idReceta
     *            the id receta
     * @return the string
     */
    public void borrar(int idReceta) {
        repo.deleteById(idReceta);
    }

    /**
     * Lista todas.
     *
     * @return the list
     */
    public List<Receta> listaTodas() {
        if (repo.findAll().isEmpty()) {
            throw new Excepcion(HttpStatus.NO_CONTENT, "No se han encontrado Recetas");
        }
        return repo.findAll();
    }

    /**
     * Buscar receta.
     *
     * @param nombreReceta
     *            the nombre receta
     * @return the list
     */
    public List<Receta> buscarReceta(String nombreReceta) {
        return repo.buscarReceta(nombreReceta);
    }

    /**
     * Ver receta.
     *
     * @param idReceta
     *            the id receta
     * @return the optional
     */
    public Optional<Receta> verReceta(int idReceta) {
        return repo.findById(idReceta);
    }

    /**
     * Agregar ingrediente.
     *
     * @param ingrediente
     *            the ingrediente
     * @return the receta ingrediente
     */
    public RecetaIngrediente agregarIngrediente(RecetaIngrediente ingrediente) {
        return repoRecetaIngrediente.save(ingrediente);
    }

    /**
     * Eliminar ingrediente.
     *
     * @param idRecetaIngrediente
     *            the id receta ingrediente
     */
    public void eliminarIngrediente(int idRecetaIngrediente) {
        repoRecetaIngrediente.deleteById(idRecetaIngrediente);
    }

    /**
     * Modificar ingrediente.
     *
     * @param ingrediente
     *            the ingrediente
     * @return the receta ingrediente
     */
    public RecetaIngrediente modificarIngrediente(RecetaIngrediente ingrediente) {
        return repoRecetaIngrediente.save(ingrediente);
    }

    /**
     * Lista ingredientes.
     *
     * @param idReceta
     *            the id receta
     * @return the list
     */
    public List<RecetaIngrediente> listaIngredientes(int idReceta) {
        return repoRecetaIngrediente.listaIngredientes(idReceta);
    }

    /**
     * Ver ingrediente.
     *
     * @param idRecetaIngrediente
     *            the id receta ingrediente
     * @return the optional
     */
    public Optional<RecetaIngrediente> verIngrediente(int idRecetaIngrediente) {
        return repoRecetaIngrediente.findById(idRecetaIngrediente);
    }
}
