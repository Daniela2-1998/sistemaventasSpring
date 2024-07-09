package com.daniela.sistemaventas.controller;

import com.daniela.sistemaventas.dto.request.CategoriasConIdRequestDto;
import com.daniela.sistemaventas.dto.request.CategoriasRequestDto;
import com.daniela.sistemaventas.dto.response.CategoriasResponseDto;
import com.daniela.sistemaventas.dto.response.MensajeRespondeDto;
import com.daniela.sistemaventas.service.CategoriasServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    CategoriasServiceImpl categoriasService;


    @GetMapping("")
    public ResponseEntity<List<CategoriasResponseDto>> getAllCategorias() {
        return new ResponseEntity<>(categoriasService.getAllCategorias(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriasResponseDto> getCategoriasById(@PathVariable Long id) {
        return new ResponseEntity<>(categoriasService.getCategoriaById(id), HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<CategoriasResponseDto> createCategorias(@RequestBody @Valid CategoriasRequestDto categoriasRequestDto) {
        return new ResponseEntity<>(categoriasService.addCategoria(categoriasRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<CategoriasResponseDto> updateCategorias(@RequestBody @Valid CategoriasConIdRequestDto categoriasConIdRequestDto){
        return new ResponseEntity<>(categoriasService.editCategoria(categoriasConIdRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<MensajeRespondeDto> deleteCategorias(@PathVariable Long id){
        return new ResponseEntity<>(categoriasService.deleteCategoria(id), HttpStatus.OK);
    }

}
