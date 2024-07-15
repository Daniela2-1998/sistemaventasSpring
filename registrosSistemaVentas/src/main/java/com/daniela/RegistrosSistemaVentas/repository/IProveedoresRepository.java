package com.daniela.RegistrosSistemaVentas.repository;

import com.daniela.RegistrosSistemaVentas.model.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProveedoresRepository extends JpaRepository <Proveedores, Long>{
}
