package com.daniela.sistemaventas.dto.response;

import com.daniela.sistemaventas.model.Categorias;
import com.daniela.sistemaventas.model.Marcas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductosSinMarcaResponseDto {

    private Long id;

    private String nombre;

    private Integer cantidad;

    private Double precio;

    private Categorias categoria;

}
