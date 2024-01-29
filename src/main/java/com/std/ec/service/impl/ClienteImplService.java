package com.std.ec.service.impl;

import com.std.ec.model.dao.ClienteDao;
import com.std.ec.model.dto.ClienteDto;
import com.std.ec.model.entity.Cliente;
import com.std.ec.service.IClienteService;
import io.swagger.v3.oas.models.examples.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
    public class ClienteImplService implements IClienteService {

        @Autowired
        private ClienteDao clienteDao;

    @Override
    public List<Cliente> listAll() {
        return (List) clienteDao.findAll();
    }

    @Transactional
        @Override
        public Cliente save(ClienteDto clienteDto) {
            Cliente cliente = Cliente.builder()
                    .id_Cliente(clienteDto.getId_Cliente())
                    .nombre(clienteDto.getNombre())
                    .apellido(clienteDto.getApellido())
                    .correo(clienteDto.getCorreo())
                    .fechaRegistro(clienteDto.getFechaRegistro())
                    .build();
            return clienteDao.save(cliente);
        }

        @Transactional(readOnly = true)
        @Override
        public Cliente findById(Integer id) {
            return clienteDao.findById(id).orElse(null);
        }

         @Override
        public List<Cliente> findByNombre(String nombre) {
             List<Cliente> clienteOptional = clienteDao.findByNombre(nombre);
             //Optional<Cliente[]> clienteOptional = clienteDao.findAll(nombre);
             return clienteOptional;
        }

        @Transactional
        @Override
        public void delete(Cliente cliente) {
            clienteDao.delete(cliente);
        }

        @Override
        public boolean existsById(Integer id) {
            return clienteDao.existsById(id);
        }
    }
