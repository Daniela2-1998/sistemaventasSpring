package com.daniela.RegistrosSistemaVentas.dto.response;

import com.daniela.RegistrosSistemaVentas.model.Clientes;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientesResponseDto {

    private Long id;

    private String nombre;

    private LocalDate fechaNacimiento;

    private String dni;

    private String telefono;

    private String direccion;

    private Clientes.TipoCliente tipo;
}
