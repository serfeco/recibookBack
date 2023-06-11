package com.recibook.recibook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recibook.recibook.entities.HojaPedidoIngrediente;

public interface HojaPedidoIngredienteRepository extends JpaRepository<HojaPedidoIngrediente, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM HOJA_PEDIDO_INGREDIENTE WHERE id_hoja_pedido=:idHojaPedido")
    public List<HojaPedidoIngrediente> listaIngredientes( int idHojaPedido);
    
   @Query(nativeQuery = true, value = "SELECT * FROM HOJA_PEDIDO_INGREDIENTE WHERE id_hoja_pedido=:idHojaPedido AND id_ingrediente=:idIngrediente")
   public List<HojaPedidoIngrediente> comprobarIngrediente(int idHojaPedido, int idIngrediente);

}
