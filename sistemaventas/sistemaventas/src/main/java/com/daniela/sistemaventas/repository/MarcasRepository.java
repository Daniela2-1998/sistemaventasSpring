package com.daniela.sistemaventas.repository;

import com.daniela.sistemaventas.model.Marcas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcasRepository extends JpaRepository<Marcas, Long> {

    List<Marcas> findByNombre(String nombre);
}
