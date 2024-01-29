package com.std.ec.model.dao;

import com.std.ec.model.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioDao extends JpaRepository<Inventario, Integer> {
}
