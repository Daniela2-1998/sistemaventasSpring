package com.daniela.RegistrosSistemaVentas.service;

import com.daniela.RegistrosSistemaVentas.dto.request.ClientesRequestConIdDto;
import com.daniela.RegistrosSistemaVentas.dto.request.ClientesRequestDto;
import com.daniela.RegistrosSistemaVentas.dto.response.ClientesResponseDto;
import com.daniela.RegistrosSistemaVentas.dto.response.MensajeRespondeDto;

import org.springframework.data.domain.Page;
import java.util.List;

public interface IClientesService {


    Page<ClientesResponseDto> getAllClientes(int page, int size, String sortBy);

    ClientesResponseDto getClienteById(Long id);

    ClientesResponseDto addCliente(ClientesRequestDto clientesRequestDto);

    ClientesResponseDto editCliente(ClientesRequestConIdDto clientesRequestConIdDto);

    MensajeRespondeDto deleteCliente(Long id);
}
