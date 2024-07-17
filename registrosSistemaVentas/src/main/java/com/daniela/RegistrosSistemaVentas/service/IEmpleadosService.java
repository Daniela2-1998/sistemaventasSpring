package com.daniela.RegistrosSistemaVentas.service;


import com.daniela.RegistrosSistemaVentas.dto.request.EmpleadosRequestConIdDto;
import com.daniela.RegistrosSistemaVentas.dto.request.EmpleadosRequestDto;
import com.daniela.RegistrosSistemaVentas.dto.response.EmpleadosResponseDto;
import com.daniela.RegistrosSistemaVentas.dto.response.MensajeRespondeDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IEmpleadosService {

    Page<EmpleadosResponseDto> getAllEmpleados(int page, int size, String sortBy);

    EmpleadosResponseDto getEmpleadoById(Long id);

    EmpleadosResponseDto addEmpleado(EmpleadosRequestDto empleadosRequestDto);

    EmpleadosResponseDto editEmpleado(EmpleadosRequestConIdDto empleadosRequestConIdDto);

    MensajeRespondeDto deleteEmpleado(Long id);

}
