package com.std.ec.controller;

import com.std.ec.model.dto.ClienteDto;
import com.std.ec.model.entity.Cliente;
import com.std.ec.model.payload.MensajeResponse;
import com.std.ec.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class    ClienteController {

    @Autowired
    private IClienteService clienteService;

    @CrossOrigin
    @GetMapping("clientes")
    public ResponseEntity<?> showAll(){
        List<Cliente> getList = clienteService.listAll();

        if (getList == null){
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("No hay registros!!")
                            .object(null)
                            .build()
                    , HttpStatus.OK);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("Consulta exitosa")
                        .object(getList)
                        .build()
                , HttpStatus.OK);
    }


    @CrossOrigin
    @PostMapping("cliente")
    public ResponseEntity<?> create(@RequestBody ClienteDto clienteDto){
        Cliente clienteSave = null;
        try {
            clienteSave = clienteService.save(clienteDto);
            
            return ResponseEntity.ok(ClienteDto.builder()
                    .id_Cliente(clienteSave.getId_Cliente())
                    .nombre(clienteSave.getNombre())
                    .apellido(clienteSave.getApellido())
                    .correo(clienteSave.getCorreo())
                    .fechaRegistro(clienteSave.getFechaRegistro())
                    .build());
        }
        catch (DataAccessException exDt){
            // guardar LOG
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Los datos ingresados presentan incoherencias")
                    .object(null)
                    .build()
                    , HttpStatus.BAD_REQUEST);
        }
    }


    @CrossOrigin
    @PutMapping("cliente/{id}")
    public ResponseEntity<?> update(@RequestBody ClienteDto clienteDto, @PathVariable Integer id){
        Cliente clienteUpdate = null;

        try {

            if (clienteService.existsById(id)){
                clienteDto.setId_Cliente(id);
                clienteUpdate = clienteService.save(clienteDto);
                return new ResponseEntity<>(MensajeResponse.builder()
                        .mensaje("Guardado correctamente")
                        .object(ClienteDto.builder()
                                .id_Cliente(clienteUpdate.getId_Cliente())
                                .nombre(clienteUpdate.getNombre())
                                .apellido(clienteUpdate.getApellido())
                                .correo(clienteUpdate.getCorreo())
                                .fechaRegistro(clienteUpdate.getFechaRegistro())
                                .build())
                        .build()
                        , HttpStatus.CREATED);
            }
            else{

                return new ResponseEntity<>(
                        MensajeResponse.builder()
                        .mensaje("El registro que intenta actualizar no se encuentra en la base de datos")
                        .object(null)
                        .build()
                        , HttpStatus.NOT_FOUND);
            }

        } catch (DataAccessException exDt){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(exDt.getMessage())
                    .object(null)
                    .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }

    }


    @CrossOrigin
    @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Cliente clienteDelete = clienteService.findById(id);
            clienteService.delete(clienteDelete);
            return new ResponseEntity<>(MensajeResponse.builder().mensaje("Cliente Eliminado correctamente").object(clienteDelete).build(), HttpStatus.OK);
        }
        catch (DataAccessException exDt){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(exDt.getMessage())
                    .object(null)
                    .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }


    @CrossOrigin
    @GetMapping("cliente/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id){
        Cliente cliente = clienteService.findById(id);

        if (cliente == null){
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                        .mensaje("El registro que intenta buscar, no existe!!")
                        .object(null)
                        .build()
                    , HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("Consulta exitosa")
                        .object(ClienteDto.builder()
                                .id_Cliente(cliente.getId_Cliente())
                                .nombre(cliente.getNombre())
                                .apellido(cliente.getApellido())
                                .correo(cliente.getCorreo())
                                .fechaRegistro(cliente.getFechaRegistro())
                                .build())
                        .build()
                , HttpStatus.OK);
    }


    @CrossOrigin
    @GetMapping("cliente/nombre/{nombre}")
    public ResponseEntity<?> showByName(@PathVariable String nombre) {
        List<Cliente> cliente = clienteService.findByNombre(nombre);

        if (cliente == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("No se encontró ningún cliente con el nombre proporcionado.")
                            .object(null)
                            .build(),
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("Consulta exitosa")
                        .object(cliente)
                        .build(),
                HttpStatus.OK);
    }
}