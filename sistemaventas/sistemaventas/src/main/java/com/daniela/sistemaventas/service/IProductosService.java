package com.daniela.sistemaventas.service;

import com.daniela.sistemaventas.dto.request.ProductosConIdRequestDto;
import com.daniela.sistemaventas.dto.request.ProductosRequestDto;
import com.daniela.sistemaventas.dto.response.MensajeRespondeDto;
import com.daniela.sistemaventas.dto.response.ProductosResponseDto;

import java.util.List;

public interface IProductosService {

    List<ProductosResponseDto> getAllProducts();

    ProductosResponseDto getProductById(Long id);

    ProductosResponseDto addProduct(ProductosRequestDto productosRequestDto, Long marcaId, Long categoriaId);

    ProductosResponseDto editProduct(ProductosConIdRequestDto productosConIdRequestDto);

    MensajeRespondeDto deleteProduct(Long id);

}
