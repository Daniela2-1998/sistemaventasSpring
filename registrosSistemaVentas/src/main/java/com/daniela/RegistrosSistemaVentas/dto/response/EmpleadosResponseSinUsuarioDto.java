package com.daniela.RegistrosSistemaVentas.dto.response;

import com.daniela.RegistrosSistemaVentas.model.Usuarios;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpleadosResponseSinUsuarioDto {

    private Long id;

    private String nombreCompleto;

    private LocalDate fechaNacimiento;

    private String cargo;

    private String telefono;

    private Double salario;

}
