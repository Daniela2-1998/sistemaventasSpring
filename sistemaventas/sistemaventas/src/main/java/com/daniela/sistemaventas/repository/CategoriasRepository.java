package com.daniela.sistemaventas.repository;

import com.daniela.sistemaventas.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {

    List<Categorias> findByNombre(String nombre);

}
