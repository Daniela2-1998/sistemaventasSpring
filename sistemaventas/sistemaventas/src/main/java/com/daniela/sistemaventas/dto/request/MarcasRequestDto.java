package com.daniela.sistemaventas.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarcasRequestDto {

    @NotNull(message = "El nombre de la marca no puede ser nulo.")
    @NotEmpty(message = "El nombre de la marca no puede estar vacío.")
    private String nombre;
    
}
