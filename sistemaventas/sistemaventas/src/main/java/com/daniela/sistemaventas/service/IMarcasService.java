package com.daniela.sistemaventas.service;


import com.daniela.sistemaventas.dto.request.MarcasConIdRequestDto;
import com.daniela.sistemaventas.dto.request.MarcasRequestDto;
import com.daniela.sistemaventas.dto.response.MarcasResponseDto;
import com.daniela.sistemaventas.dto.response.MensajeRespondeDto;

import java.util.List;

public interface IMarcasService {

    List<MarcasResponseDto> getAllMarcas();

    MarcasResponseDto getMarcaById(Long id);

    MarcasResponseDto addMarca(MarcasRequestDto marcaRequestDto);

    MarcasResponseDto editMarca (MarcasConIdRequestDto marcaConIdRequestDto);

    MensajeRespondeDto deleteMarca (Long id);

}
