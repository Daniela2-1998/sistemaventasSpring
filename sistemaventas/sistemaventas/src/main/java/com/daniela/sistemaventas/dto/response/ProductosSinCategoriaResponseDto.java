package com.daniela.sistemaventas.dto.response;

import com.daniela.sistemaventas.model.Categorias;
import com.daniela.sistemaventas.model.Marcas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductosSinCategoriaResponseDto {

    private Long id;

    private String nombre;

    private String descripcion;

    private Integer cantidad;

    private Double precio;

    private Marcas marca;
}
