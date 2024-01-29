package com.std.ec.service;

import com.std.ec.model.dto.InventarioDto;
import com.std.ec.model.entity.Inventario;

public interface IInventario {

     Inventario save(Inventario inventario);
    Inventario findById(Integer sku);
    void delete(Inventario inventario);

    boolean existsBySKU(Integer SKU);

}
  /*
    InventarioDto save(InventarioDto inventario);
    InventarioDto findById(Integer sku);
    void delete(InventarioDto inventario);
}
   */