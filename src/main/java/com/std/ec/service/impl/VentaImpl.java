package com.std.ec.service.impl;

import com.std.ec.model.dao.VentaDao;
import com.std.ec.model.entity.Venta;
import com.std.ec.service.IVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VentaImpl implements IVenta {
    @Autowired
    private VentaDao ventaDao;
    @Transactional
    @Override
    public Venta save(Venta venta) {
        return ventaDao.save(venta);
    }
    @Transactional(readOnly = true)
    @Override
    public Venta findById(Integer id) {
        return ventaDao.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public void delete(Venta venta) {
        ventaDao.delete(venta);
    }
}
