package com.daniela.sistemaventas.repository;

import com.daniela.sistemaventas.model.Categorias;
import com.daniela.sistemaventas.model.Marcas;
import com.daniela.sistemaventas.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long> {

    List<Productos> findByNombre (String nombre);
    List<Productos> findByCategoria (Categorias categoria);
    List<Productos> findByMarca (Marcas marca);
}
