package com.daniela.RegistrosSistemaVentas.dto.request;

import com.daniela.RegistrosSistemaVentas.model.Clientes;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientesRequestDto {

    @NotBlank(message = "El nombre del cliente no puede estar vacío.")
    @Size(min = 2, max = 100, message = "El nombre del cliente debe contener entre 2 y 100 caracteres.")
    private String nombre;

    @Past
    private LocalDate fechaNacimiento;

    @NotBlank(message = "Debes ingresar el DNI del cliente.")
    private String dni;

    @NotBlank(message = "Debes ingresar el teléfono de contacto del cliente.")
    @Pattern(regexp = "^\\+?[0-9]{8,15}$", message = "El teléfono debe tener la estructura correspondiente.")
    private String telefono;

    @NotBlank(message = "La dirección del cliente no puede estar vacía.")
    @Size(max = 200)
    private String direccion;

    @Enumerated(EnumType.STRING)
    private Clientes.TipoCliente tipo;
}
