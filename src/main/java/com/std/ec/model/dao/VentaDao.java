package com.std.ec.model.dao;

import com.std.ec.model.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VentaDao extends JpaRepository<Venta, Integer> {

}
