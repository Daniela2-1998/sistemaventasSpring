package com.daniela.RegistrosSistemaVentas.repository;

import com.daniela.RegistrosSistemaVentas.model.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadosRepository extends JpaRepository <Empleados, Long>{
}
