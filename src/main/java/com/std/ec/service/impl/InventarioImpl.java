package com.std.ec.service.impl;

import com.std.ec.model.dao.InventarioDao;
import com.std.ec.model.entity.Inventario;
import com.std.ec.service.IInventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventarioImpl implements IInventario {

    @Autowired
    private InventarioDao inventarioDao;
    @Transactional
    @Override
    public Inventario save(Inventario inventario) {
        return inventarioDao.save(inventario);
    }
    @Transactional(readOnly = true)
    @Override
    public Inventario findById(Integer id) {
        return inventarioDao.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public void delete(Inventario inventario) {
        inventarioDao.delete(inventario);
    }

    @Override
    public boolean existsBySKU(Integer sku) {
        return false;
    }
}
