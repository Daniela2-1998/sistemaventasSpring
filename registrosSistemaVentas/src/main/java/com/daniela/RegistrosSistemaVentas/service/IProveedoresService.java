package com.daniela.RegistrosSistemaVentas.service;

import com.daniela.RegistrosSistemaVentas.dto.request.ProveedoresRequestConIdDto;
import com.daniela.RegistrosSistemaVentas.dto.request.ProveedoresRequestDto;
import com.daniela.RegistrosSistemaVentas.dto.response.MensajeRespondeDto;
import com.daniela.RegistrosSistemaVentas.dto.response.ProveedoresResponseDto;

import java.util.List;



public interface IProveedoresService {

    List<ProveedoresResponseDto> getAllProveedores();

    ProveedoresResponseDto getProveedorById(Long id);

    ProveedoresResponseDto addProveedor(ProveedoresRequestDto proveedoresRequestDto);

    ProveedoresResponseDto editProveedor(ProveedoresRequestConIdDto proveedoresRequestConIdDto);

    MensajeRespondeDto deleteProveedor(Long id);

}
