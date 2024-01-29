package com.std.ec.service;

import com.std.ec.model.dto.ClienteDto;
import com.std.ec.model.entity.Cliente;

import java.util.List;

public interface IClienteService {

    List<Cliente> listAll();

    Cliente save(ClienteDto cliente);

    Cliente findById(Integer id);

    List<Cliente> findByNombre(String nombre);

    void delete(Cliente cliente);

    boolean existsById(Integer id);


}