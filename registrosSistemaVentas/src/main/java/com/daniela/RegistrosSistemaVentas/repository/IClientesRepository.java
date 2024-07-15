package com.daniela.RegistrosSistemaVentas.repository;

import com.daniela.RegistrosSistemaVentas.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientesRepository extends JpaRepository <Clientes, Long>{
}
