package com.daniela.RegistrosSistemaVentas.controller;

import com.daniela.RegistrosSistemaVentas.dto.request.ClientesRequestConIdDto;
import com.daniela.RegistrosSistemaVentas.dto.request.ClientesRequestDto;
import com.daniela.RegistrosSistemaVentas.dto.response.APIResponse;
import com.daniela.RegistrosSistemaVentas.dto.response.ClientesResponseDto;
import com.daniela.RegistrosSistemaVentas.dto.response.MensajeRespondeDto;
import com.daniela.RegistrosSistemaVentas.service.ClientesServiceImp;
import com.daniela.RegistrosSistemaVentas.service.IClientesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/clientes")
public class ClientesController {


    private static final Logger log = LoggerFactory.getLogger(ClientesController.class);

    @Autowired
    IClientesService clientesService;


    // Constructor
    public ClientesController(ClientesServiceImp clientesServiceImp) {
        this.clientesService = clientesServiceImp;
    }


    @CrossOrigin
    @GetMapping("")
    public ResponseEntity<Page<ClientesResponseDto>> getAllClientes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ){
        log.info("Clientes encontrados en sistema.");
        return new ResponseEntity<>(clientesService.getAllClientes(page, size, sortBy), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ClientesResponseDto> getClientesById(@PathVariable Long id){
        log.info("Cliente encontrado en sistema.");
        return new ResponseEntity<>(clientesService.getClienteById(id), HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<APIResponse<ClientesResponseDto>> createClientes(@RequestBody @Valid ClientesRequestDto clientesRequestDto){
        try {
            ClientesResponseDto nuevoCliente = clientesService.addCliente(clientesRequestDto);
            APIResponse<ClientesResponseDto> response = new APIResponse<>(true, "Cliente creado exitosamente", nuevoCliente);
            log.info("Nuevo cliente registrado: ID={}, Nombre={}", nuevoCliente.getId(), nuevoCliente.getNombre());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            APIResponse<ClientesResponseDto> response = new APIResponse<>(false, "Error al crear cliente: " + e.getMessage(), null);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<APIResponse<ClientesResponseDto>> updateClientes(@RequestBody @Valid ClientesRequestConIdDto clientesRequestConIdDto){
        try {
            ClientesResponseDto clienteActualizado = clientesService.editCliente(clientesRequestConIdDto);
            APIResponse<ClientesResponseDto> response = new APIResponse<>(true, "Cliente actualizado exitosamente", clienteActualizado);
            return ResponseEntity.ok(response);
        } catch (NoSuchElementException e) {
            APIResponse<ClientesResponseDto> response = new APIResponse<>(false, "Cliente no encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<APIResponse<MensajeRespondeDto>> deleteClientes(@PathVariable Long id){
        try {
            clientesService.deleteCliente(id);
            log.trace("Eliminación éxitosa.");
            APIResponse<MensajeRespondeDto> response =
                    new APIResponse<>(true, "Cliente eliminado exitosamente", null);
            return ResponseEntity.ok(response);
        } catch (NoSuchElementException e) {
            log.error("Error al eliminar registro solicitado.");
            APIResponse<MensajeRespondeDto> response = new APIResponse<>(false, "Cliente no encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
