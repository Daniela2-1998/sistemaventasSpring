package com.daniela.sistemaventas.dto.response;

import com.daniela.sistemaventas.model.Categorias;
import com.daniela.sistemaventas.model.Marcas;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductosResponseDto {

    private Long id;

    private String nombre;

    private Integer cantidad;

    private Double precio;

    private Categorias categoria;

    private Marcas marca;
}
