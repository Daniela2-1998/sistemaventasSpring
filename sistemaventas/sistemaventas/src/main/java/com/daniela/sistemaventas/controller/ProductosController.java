package com.daniela.sistemaventas.controller;

import com.daniela.sistemaventas.dto.request.ProductosConIdRequestDto;
import com.daniela.sistemaventas.dto.request.ProductosRequestDto;
import com.daniela.sistemaventas.dto.response.MensajeRespondeDto;
import com.daniela.sistemaventas.dto.response.ProductosResponseDto;
import com.daniela.sistemaventas.service.ProductosServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    ProductosServiceImpl productosService;


    @CrossOrigin
    @GetMapping("")
    public ResponseEntity<List<ProductosResponseDto>> getAllProductos(){
        return new ResponseEntity<>(productosService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductosResponseDto> getProductoById(@PathVariable Long id){
        return new ResponseEntity<>(productosService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<ProductosResponseDto> createProducto(@RequestBody @Valid ProductosRequestDto productosRequestDto){
        return new ResponseEntity<>(productosService.addProduct(productosRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<ProductosResponseDto> updateProducto(@RequestBody @Valid ProductosConIdRequestDto productosConIdRequestDto){
        return new ResponseEntity<>(productosService.editProduct(productosConIdRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<MensajeRespondeDto> deleteProducto(@PathVariable Long id){
        return new ResponseEntity<>(productosService.deleteProduct(id), HttpStatus.OK);
    }
}
