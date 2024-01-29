package com.std.ec.model.dao;

import com.std.ec.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface ClienteDao extends JpaRepository<Cliente, Integer> {
    @Query(value = "Select * from clientes where nombre ilike %:nombre%", nativeQuery = true)
    List<Cliente> findByNombre(String nombre);

}
