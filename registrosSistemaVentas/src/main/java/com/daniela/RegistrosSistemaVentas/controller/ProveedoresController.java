package com.daniela.RegistrosSistemaVentas.controller;

import com.daniela.RegistrosSistemaVentas.dto.request.ProveedoresRequestConIdDto;
import com.daniela.RegistrosSistemaVentas.dto.request.ProveedoresRequestDto;
import com.daniela.RegistrosSistemaVentas.dto.response.APIResponse;
import com.daniela.RegistrosSistemaVentas.dto.response.MensajeRespondeDto;
import com.daniela.RegistrosSistemaVentas.dto.response.ProveedoresResponseDto;
import com.daniela.RegistrosSistemaVentas.service.IProveedoresService;
import com.daniela.RegistrosSistemaVentas.service.ProveedoresServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/proveedores")
public class ProveedoresController {

    @Autowired
    IProveedoresService proveedoresService;

    // Constructor
    public ProveedoresController(ProveedoresServiceImp proveedoresServiceImp) {
        this.proveedoresService = proveedoresServiceImp;
    }


    @CrossOrigin
    @GetMapping("")
    public ResponseEntity<List<ProveedoresResponseDto>> getAllProveedores(){
        return new ResponseEntity<>(proveedoresService.getAllProveedores(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedoresResponseDto> getProveedoresById(@PathVariable Long id){
        return new ResponseEntity<>(proveedoresService.getProveedorById(id), HttpStatus.OK);
    }


    @PostMapping("/agregar")
    public ResponseEntity<APIResponse<ProveedoresResponseDto>> createProveedores(@RequestBody @Valid ProveedoresRequestDto proveedoresRequestDto){
        try {
            ProveedoresResponseDto nuevoProveedor = proveedoresService.addProveedor(proveedoresRequestDto);
            APIResponse<ProveedoresResponseDto> response = new APIResponse<>(true, "Proveedor creado exitosamente", nuevoProveedor);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            APIResponse<ProveedoresResponseDto> response = new APIResponse<>(false, "Error al crear proveedor: "
                    + e.getMessage(), null);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<APIResponse<ProveedoresResponseDto>> updateProveedores(@RequestBody @Valid ProveedoresRequestConIdDto
                                                                                             proveedoresRequestConIdDto){
        try {
            ProveedoresResponseDto clienteActualizado = proveedoresService.editProveedor(proveedoresRequestConIdDto);
            APIResponse<ProveedoresResponseDto> response = new APIResponse<>(true, "Proveedor actualizado exitosamente",
                    clienteActualizado);
            return ResponseEntity.ok(response);
        } catch (NoSuchElementException e) {
            APIResponse<ProveedoresResponseDto> response = new APIResponse<>(false, "Proveedor no encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<APIResponse<MensajeRespondeDto>> deleteProveedores(@PathVariable Long id){
        try {
            proveedoresService.deleteProveedor(id);
            APIResponse<MensajeRespondeDto> response =
                    new APIResponse<>(true, "Proveedor eliminado exitosamente", null);
            return ResponseEntity.ok(response);
        } catch (NoSuchElementException e) {
            APIResponse<MensajeRespondeDto> response = new APIResponse<>(false, "Proveedor no encontrado", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
