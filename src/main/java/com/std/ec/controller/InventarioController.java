package com.std.ec.controller;

import com.std.ec.model.entity.Inventario;
import com.std.ec.model.entity.Venta;
import com.std.ec.model.payload.MensajeResponse;
import com.std.ec.service.IInventario;
import com.std.ec.service.IVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class InventarioController {

    @Autowired
    private IInventario inventarioService;
    @PostMapping("inventario") //LE FALTA MI CHAVO
    public Inventario create(@RequestBody Inventario inventario)
    {
        return inventarioService.save(inventario);
    }
    @PutMapping("inventario")
    public Inventario update(@RequestBody Inventario inventario)
    {
        return inventarioService.save(inventario);
    }
    @DeleteMapping("inventario/{sku}")
    public ResponseEntity<?> delete(@PathVariable Integer sku)
    {
        Map<String, Object> response = new HashMap<>();
        try {
        Inventario inventarioDelete = inventarioService.findById(sku);
        inventarioService.delete(inventarioDelete);
        return new ResponseEntity<>(MensajeResponse.builder().mensaje("Articulo eliminado correctamente del inventario").object(inventarioDelete).build(), HttpStatus.OK);
        }
        catch (DataAccessException exDt){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(exDt.getMessage())
                    .object(null)
                    .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }
    @GetMapping("inventario/{sku}")
    public Inventario showById(@PathVariable Integer sku)
    {
        return inventarioService.findById(sku);
    }


}










