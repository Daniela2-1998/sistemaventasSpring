package com.daniela.sistemaventas.dto.request;

import com.daniela.sistemaventas.model.Categorias;
import com.daniela.sistemaventas.model.Marcas;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductosRequestDto {

    @NotNull(message = "El campo nombre de producto no puede ser nulo.")
    @NotEmpty(message = "El campo nombre de producto no puede estar vacío.")
    private String nombre;

    @NotNull(message = "El campo descripción de producto no puede ser nulo.")
    @NotEmpty(message = "El campo descripción de producto no puede estar vacío.")
    @Column(length = 1000)
    private String descripcion;

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
