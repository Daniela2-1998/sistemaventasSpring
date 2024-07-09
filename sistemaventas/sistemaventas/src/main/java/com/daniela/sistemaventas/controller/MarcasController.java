package com.daniela.sistemaventas.controller;

import com.daniela.sistemaventas.dto.request.MarcasConIdRequestDto;
import com.daniela.sistemaventas.dto.request.MarcasRequestDto;
import com.daniela.sistemaventas.dto.response.MarcasResponseDto;
import com.daniela.sistemaventas.dto.response.MensajeRespondeDto;
import com.daniela.sistemaventas.service.MarcasServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcasController {

    @Autowired
    MarcasServiceImpl marcasService;



    @GetMapping("")
    public ResponseEntity<List<MarcasResponseDto>> getAllMarcas(){
        return new ResponseEntity<>(marcasService.getAllMarcas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcasResponseDto> getMarcasById(@PathVariable Long id){
        return new ResponseEntity<>(marcasService.getMarcaById(id), HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<MarcasResponseDto> createMarcas(@RequestBody @Valid MarcasRequestDto marcasRequestDto){
        return new ResponseEntity<>(marcasService.addMarca(marcasRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<MarcasResponseDto> updateMarcas(@RequestBody @Valid MarcasConIdRequestDto marcasConIdRequestDto){
        return new ResponseEntity<>(marcasService.editMarca(marcasConIdRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<MensajeRespondeDto> deleteMarcas(@PathVariable Long id){
        return new ResponseEntity<>(marcasService.deleteMarca(id), HttpStatus.OK);
    }

}
