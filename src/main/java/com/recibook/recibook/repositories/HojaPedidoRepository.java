package com.recibook.recibook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recibook.recibook.entities.HojaPedido;

public interface HojaPedidoRepository extends JpaRepository<HojaPedido, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM hojas_pedido WHERE id_local=:idLocal")
    public List<HojaPedido> hpLocal(int idLocal);
}
