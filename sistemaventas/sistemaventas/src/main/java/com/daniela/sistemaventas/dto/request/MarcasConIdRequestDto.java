package com.daniela.sistemaventas.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarcasConIdRequestDto {

    @NotNull(message = "El ID de la marca no puede ser nulo.")
    private Long id;

    @NotNull(message = "El nombre de la marca no puede ser nulo.")
    @NotEmpty(message = "El nombre de la marca no puede estar vacío.")
    private String nombre;

}
