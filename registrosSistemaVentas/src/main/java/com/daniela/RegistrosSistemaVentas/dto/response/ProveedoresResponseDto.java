package com.daniela.RegistrosSistemaVentas.dto.response;

import com.daniela.RegistrosSistemaVentas.model.Proveedores;
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
public class ProveedoresResponseDto {

    private Long id;

    private String empresa;

    private String identificacion;

    private String mail;

    private String telefono;

    private String direccion;

    private String contacto;

    private Proveedores.TipoProveedor tipo;

    private String descripcion;

    private LocalDate fechaRegistro;

}
