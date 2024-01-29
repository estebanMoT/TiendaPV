package com.std.ec.service;

import com.std.ec.model.entity.Venta;

public interface IVenta {
    Venta save(Venta venta);
    Venta findById(Integer notadeventa);
    void delete(Venta venta);
}
