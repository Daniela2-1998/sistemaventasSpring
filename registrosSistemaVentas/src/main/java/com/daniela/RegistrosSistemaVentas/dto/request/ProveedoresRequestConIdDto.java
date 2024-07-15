package com.daniela.RegistrosSistemaVentas.dto.request;

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
public class ProveedoresRequestConIdDto {

    @NotNull(message = "El ID del proveedor no puede ser nulo.")
    private Long id;

    @NotBlank(message = "El nombre de la empresa no puede estar vacío.")
    @Size(min = 2, max = 100, message = "El nombre de la empresa debe contener entre 2 y 100 caracteres.")
    private String empresa;

    @NotBlank(message = "La identificación de la empresa no puede estar vacía.")
    @Size(max = 20, message = "La identificación no puede superar los 20 caracteres.")
    private String identificacion;

    @NotBlank(message = "Debes completar el campo correspondiente al mail.")
    @Email(message = "El mail debe tener la estructura correspondiente.")
    private String mail;

    @NotBlank(message = "Debes ingresar el teléfono de contacto de la empresa.")
    @Pattern(regexp = "^\\+?[0-9]{8,15}$", message = "El teléfono debe tener la estructura correspondiente.")
    private String telefono;

    @NotBlank(message = "La dirección de la empresa no puede quedar en blanco.")
    @Size(max = 200)
    private String direccion;

    @NotBlank(message = "El nombre de contacto no puede quedar vacío.")
    @Size(max = 100)
    private String contacto;

    @Enumerated(EnumType.STRING)
    private Proveedores.TipoProveedor tipo;

    @NotBlank(message = "Debes ingresar una descripción sobre la empresa y sus servicios.")
    @Size(max = 1000)
    private String descripcion;

    @PastOrPresent
    private LocalDate fechaRegistro;

}
