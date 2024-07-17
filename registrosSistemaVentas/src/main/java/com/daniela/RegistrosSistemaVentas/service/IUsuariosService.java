package com.daniela.RegistrosSistemaVentas.service;


import com.daniela.RegistrosSistemaVentas.dto.request.UsuariosRequestConIdDto;
import com.daniela.RegistrosSistemaVentas.dto.request.UsuariosRequestDto;
import com.daniela.RegistrosSistemaVentas.dto.response.MensajeRespondeDto;
import com.daniela.RegistrosSistemaVentas.dto.response.UsuariosResponseDto;

import java.util.List;

public interface IUsuariosService {

    List<UsuariosResponseDto> getAllUsuarios();

    UsuariosResponseDto getUsuarioById(Long id);

    UsuariosResponseDto addUsuario(UsuariosRequestDto usuariosRequestDto);

    UsuariosResponseDto editUsuario(UsuariosRequestConIdDto usuariosRequestConIdDto);

    MensajeRespondeDto deleteUsuario(Long id);
}
