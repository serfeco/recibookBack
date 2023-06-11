package com.recibook.recibook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.recibook.recibook.entities.HojaPedido;
import com.recibook.recibook.entities.HojaPedidoIngrediente;
import com.recibook.recibook.exceptions.Excepcion;
import com.recibook.recibook.repositories.HojaPedidoIngredienteRepository;
import com.recibook.recibook.repositories.HojaPedidoRepository;

@Service
public class HojaPedidoService {

    @Autowired
    private HojaPedidoRepository repo;
    
    @Autowired
    private HojaPedidoIngredienteRepository repoHPIngrediente;
    
    public HojaPedido crear(HojaPedido hoja)  {
        int id = repo.save(hoja).getIdHojaPedido();
        repo.findById(hoja.getIdHojaPedido());
        for(HojaPedidoIngrediente hpIngrediente : hoja.getHojaPedidoIngrediente()) {
            if(repoHPIngrediente.comprobarIngrediente(hpIngrediente.getHojaPedido().getIdHojaPedido(), hpIngrediente.getIngrediente().getIdIngrediente()).isEmpty()) {
                hpIngrediente.getHojaPedido().setIdHojaPedido(id);
                agregarIngrediente(hpIngrediente);
            }

        }
        return hoja;
    }
    
    public HojaPedido modificar(HojaPedido hoja) {
        repo.save(hoja);
         for(HojaPedidoIngrediente hpIngrediente : hoja.getHojaPedidoIngrediente()) {
             if(repoHPIngrediente.comprobarIngrediente(hpIngrediente.getHojaPedido().getIdHojaPedido(), hpIngrediente.getIngrediente().getIdIngrediente()).isEmpty()) {
                 hpIngrediente.getHojaPedido().setIdHojaPedido(hoja.getIdHojaPedido());
                 agregarIngrediente(hpIngrediente);
             }

         }
        
         return hoja;
     }
    
    public String borrar(int idHojaPedido) {
        repo.deleteById(idHojaPedido);
        return "Hoja de pedido eliminada correctamente";
    }
    
    public List<HojaPedido> listaTodas() {
        if (repo.findAll().isEmpty()) {
            throw new Excepcion(HttpStatus.NO_CONTENT, "No se han encontrado hojas de pedido");
        }
        return repo.findAll();
    }
    
    public Optional<HojaPedido> verHojaPedido(int idHojaPedido) {
        return repo.findById(idHojaPedido);
    }
    
    public HojaPedidoIngrediente agregarIngrediente(HojaPedidoIngrediente ingrediente) {
        return repoHPIngrediente.save(ingrediente); 
     }
    
    public void eliminarIngrediente(int idHojaPedidoIngrediente) {
        repoHPIngrediente.deleteById(idHojaPedidoIngrediente);
    }
    
    public HojaPedidoIngrediente modificarIngrediente(HojaPedidoIngrediente ingrediente) {
        return repoHPIngrediente.save(ingrediente);
    }
    
    public List<HojaPedidoIngrediente> listaIngredientes(int idHojaPedido){
        return repoHPIngrediente.listaIngredientes(idHojaPedido);
    }
    public Optional<HojaPedidoIngrediente> verIngrediente(int idHojaPedidoIngrediente) {
        return repoHPIngrediente.findById(idHojaPedidoIngrediente);
    }
    
}
