package com.std.ec.controller;

import com.std.ec.model.entity.Venta;
import com.std.ec.model.payload.MensajeResponse;
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
public class VentaController {

    @Autowired
    private IVenta ventaService;

    @PostMapping("venta")
    public ResponseEntity<?> create(@RequestBody Venta venta) {
        try {
            return ResponseEntity.ok(ventaService.save(venta));
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Los datos ingresados presentan incoherencias")
                    .object(null)
                    .build()
                    , HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("venta")
    public ResponseEntity<?> update(@RequestBody Venta venta) {
        return ResponseEntity.ok(ventaService.save(venta));
    }

    @DeleteMapping("venta/{notadeventa}")
    public ResponseEntity<?> delete(@PathVariable Integer notadeventa) {
        Map<String, Object> response = new HashMap<>();
        try {
            Venta ventaDelete = ventaService.findById(notadeventa);
            ventaService.delete(ventaDelete);
            return new ResponseEntity<>(MensajeResponse.builder().mensaje("Nota de venta eliminada correctamente").object(ventaDelete).build(), HttpStatus.OK);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(exDt.getMessage())
                    .object(null)
                    .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("venta/{notadeventa}")
    @ResponseStatus(HttpStatus.OK)
    public Venta showById(@PathVariable Integer notadeventa) {
        return ventaService.findById(notadeventa);
    }
}