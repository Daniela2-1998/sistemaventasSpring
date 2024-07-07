package com.daniela.sistemaventas.dto.request;

import com.daniela.sistemaventas.model.Categorias;
import com.daniela.sistemaventas.model.Marcas;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductosConIdRequestDto {

    @NotNull(message = "El campo ID de producto no puede ser nulo.")
    private Long id;

    @NotNull(message = "El campo nombre de producto no puede ser nulo.")
    @NotEmpty(message = "El campo nombre de producto no puede estar vacío.")
    private String nombre;

    @NotNull(message = "El campo cantidad de producto no puede ser nulo.")
    @PositiveOrZero
    @Min(0)
    private Integer cantidad;

    @NotNull(message = "El campo precio de producto no puede ser nulo.")
    @PositiveOrZero
    private Double precio;

    @NotNull(message = "El campo categoría de producto no puede estar vacío.")
    private Categorias categoria;

    @NotNull(message = "El campo marca de producto no puede estar vacío.")
    private Marcas marca;
}
