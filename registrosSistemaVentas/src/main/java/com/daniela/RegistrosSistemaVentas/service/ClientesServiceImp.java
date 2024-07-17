package com.daniela.RegistrosSistemaVentas.service;

import com.daniela.RegistrosSistemaVentas.dto.request.ClientesRequestConIdDto;
import com.daniela.RegistrosSistemaVentas.dto.request.ClientesRequestDto;
import com.daniela.RegistrosSistemaVentas.dto.response.ClientesResponseDto;
import com.daniela.RegistrosSistemaVentas.dto.response.MensajeRespondeDto;
import com.daniela.RegistrosSistemaVentas.exceptions.InsertionDBException;
import com.daniela.RegistrosSistemaVentas.model.Clientes;
import com.daniela.RegistrosSistemaVentas.repository.IClientesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;



@Service
public class ClientesServiceImp implements IClientesService{

    @Autowired
    IClientesRepository clientesRepository;

    ModelMapper mapper;

    // Constructor
    public ClientesServiceImp(IClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
        this.mapper = new ModelMapper();
    }



    // Métodos
    @Override
    public Page<ClientesResponseDto> getAllClientes(int page, int size, String sortBy){
            Sort sort = Sort.by(Sort.Direction.ASC, sortBy);
            Pageable pageable = PageRequest.of(page, size, sort);

            Page<Clientes> clientesPage = clientesRepository.findAll(pageable);

            if (clientesPage.isEmpty()) {
                throw new EntityNotFoundException("No se encontraron clientes registrados en el sistema.");
            }

            return clientesPage.map(cliente -> mapper.map(cliente, ClientesResponseDto.class));
    }

    @Override
    public ClientesResponseDto getClienteById(Long id) {
        Optional<Clientes> cliente = clientesRepository.findById(id);
        if (cliente.isEmpty()){
            throw new EntityNotFoundException("No se encontró un cliente con el ID: " + id + ".");
        }

        return mapper.map(cliente, ClientesResponseDto.class);
    }

    @Override
    public ClientesResponseDto addCliente(ClientesRequestDto clientesRequestDto) {
        Clientes cliente = mapper.map(clientesRequestDto, Clientes.class);
        Clientes clientePersist = clientesRepository.save(cliente);
        if (clientePersist == null){
            throw new InsertionDBException("No fue posible guardar al cliente " + cliente.getNombre() + " en la base de datos.");
        }

        return mapper.map(clientePersist, ClientesResponseDto.class);
    }

    @Override
    public ClientesResponseDto editCliente(ClientesRequestConIdDto clientesRequestConIdDto) {
        ClientesResponseDto clientesResponse = getClienteById(clientesRequestConIdDto.getId());
        if(clientesResponse == null){
            throw new EntityNotFoundException("No fue posible encontrar al cliente con el ID: " + clientesRequestConIdDto.getId());
        }

        Clientes cliente = mapper.map(clientesRequestConIdDto, Clientes.class);
        Clientes clientesPersist = clientesRepository.save(cliente);
        if(clientesPersist == null){
            throw new InsertionDBException("No fue posible guardar al cliente " + cliente.getNombre() + " - " + cliente.getDni() +
                    " en la base de datos");
        }

        return mapper.map(clientesPersist, ClientesResponseDto.class);
    }

    @Override
    public MensajeRespondeDto deleteCliente(Long id) {
        clientesRepository.deleteById(id);
        return new MensajeRespondeDto("Se eliminó correctamente al cliente solicitado.");
    }
}
