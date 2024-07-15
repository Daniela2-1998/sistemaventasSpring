package com.daniela.RegistrosSistemaVentas.dto.request;

import com.daniela.RegistrosSistemaVentas.model.Usuarios;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpleadosRequestDto {

    @NotNull(message = "El nombre completo del empleado no puede ser nulo.")
    @NotEmpty(message = "El nombre completo del empleado no puede estar vacío.")
    @Size(min = 4, max = 50)
    private String nombreCompleto;

    @NotNull(message = "La fecha de nacimiento del empleado no puede ser nula.")
    @Past
    private LocalDate fechaNacimiento;

    @NotNull(message = "El cargo del empleado no puede ser nulo.")
    @NotEmpty(message = "El cargo del empleado no puede estar vacío.")
    private String cargo;

    @Pattern(regexp = "^[0-9]{9}$")
    private String telefono;

    @PositiveOrZero
    private Double salario;

    @NotNull(message = "El usuario del empleado no puede ser nulo.")
    private Usuarios usuario;


}
