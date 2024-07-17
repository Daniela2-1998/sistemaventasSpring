package com.daniela.RegistrosSistemaVentas.dto.response;

import com.daniela.RegistrosSistemaVentas.model.Usuarios;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuariosResponseDto {

    private Long id;

    private String nombreUsuario;

    private String contraseña;

    private String mail;

    private Usuarios.Rol rol;

    private Usuarios.Estado estado;
}
