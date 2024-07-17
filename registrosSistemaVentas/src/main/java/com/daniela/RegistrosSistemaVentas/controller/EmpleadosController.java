package com.daniela.RegistrosSistemaVentas.controller;

import com.daniela.RegistrosSistemaVentas.dto.request.ClientesRequestConIdDto;
import com.daniela.RegistrosSistemaVentas.dto.request.ClientesRequestDto;
import com.daniela.RegistrosSistemaVentas.dto.request.EmpleadosRequestConIdDto;
import com.daniela.RegistrosSistemaVentas.dto.request.EmpleadosRequestDto;
import com.daniela.RegistrosSistemaVentas.dto.response.APIResponse;
import com.daniela.RegistrosSistemaVentas.dto.response.ClientesResponseDto;
import com.daniela.RegistrosSistemaVentas.dto.response.EmpleadosResponseDto;
import com.daniela.RegistrosSistemaVentas.dto.response.MensajeRespondeDto;
import com.daniela.RegistrosSistemaVentas.service.EmpleadosServiceImp;
import com.daniela.RegistrosSistemaVentas.service.IEmpleadosService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/empleados")
public class EmpleadosController {

    private static final Logger log = LoggerFactory.getLogger(EmpleadosController.class);

    @Autowired
    IEmpleadosService empleadosService;

    // Constructor
    public EmpleadosController(EmpleadosServiceImp empleadosServiceImp) {
        this.empleadosService = empleadosServiceImp;
    }

    @CrossOrigin
    @GetMapping("")
    public ResponseEntity<Page<EmpleadosResponseDto>> getAllEmpleados(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ){
        log.info("Empleados encontrados en sistema.");
        return new ResponseEntity<>(empleadosService.getAllEmpleados(page, size, sortBy), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadosResponseDto> getEmpleadosById(@PathVariable Long id){
        log.info("Empleado encontrado en sistema.");
        return new ResponseEntity<>(empleadosService.getEmpleadoById(id), HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<APIResponse<EmpleadosResponseDto>> createEmpleados(@RequestBody @Valid EmpleadosRequestDto empleadosRequestDto){
        try {
            EmpleadosResponseDto nuevoEmpleado = empleadosService.addEmpleado(empleadosRequestDto);
            APIResponse<EmpleadosResponseDto> response = new APIResponse<>(true, "Empleado creado exitosamente", nuevoEmpleado);
            log.info("Nuevo empleado registrado: ID={}, Nombre={}", nuevoEmpleado.getId(), nuevoEmpleado.getNombreCompleto());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            APIResponse<EmpleadosResponseDto> response = new APIResponse<>(false, "Error al crear empleado: " + e.getMessage(), null);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<APIResponse<EmpleadosResponseDto>> updateEmpleados(@RequestBody @Valid EmpleadosRequestConIdDto empleadosRequestConIdDto){
        try {
            EmpleadosResponseDto empleadoActualizado = empleadosService.editEmpleado(empleadosRequestConIdDto);
            APIResponse<EmpleadosResponseDto> response = new APIResponse<>(true, "Empleado actualizado exitosamente", empleadoActualizado);
            return ResponseEntity.ok(response);
        } catch (NoSuchElementException e) {
            APIResponse<EmpleadosResponseDto> response = new APIResponse<>(false, "Empleado no encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<APIResponse<MensajeRespondeDto>> deleteEmpleados(@PathVariable Long id){
        try {
            empleadosService.deleteEmpleado(id);
            log.trace("Eliminación éxitosa.");
            APIResponse<MensajeRespondeDto> response =
                    new APIResponse<>(true, "Empleado eliminado exitosamente", null);
            return ResponseEntity.ok(response);
        } catch (NoSuchElementException e) {
            log.error("Error al eliminar registro solicitado.");
            APIResponse<MensajeRespondeDto> response = new APIResponse<>(false, "Empleado no encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }



}
