package com.daniela.sistemaventas.service;

import com.daniela.sistemaventas.dto.request.CategoriasConIdRequestDto;
import com.daniela.sistemaventas.dto.request.CategoriasRequestDto;
import com.daniela.sistemaventas.dto.response.CategoriasResponseDto;
import com.daniela.sistemaventas.dto.response.MensajeRespondeDto;

import java.util.List;

public interface ICategoriasService {

    List<CategoriasResponseDto> getAllCategorias();

    CategoriasResponseDto getCategoriaById(Long id);

    CategoriasResponseDto addCategoria (CategoriasRequestDto categoriaRequestDto);

    CategoriasResponseDto editCategoria (CategoriasConIdRequestDto categoriaConIdRequestDto);

    MensajeRespondeDto deleteCategoria(Long id);
}
