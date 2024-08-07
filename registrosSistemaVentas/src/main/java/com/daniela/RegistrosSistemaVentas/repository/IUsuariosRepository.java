package com.daniela.RegistrosSistemaVentas.repository;

import com.daniela.RegistrosSistemaVentas.dto.response.UsuariosResponseDto;
import com.daniela.RegistrosSistemaVentas.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuariosRepository extends JpaRepository <Usuarios, Long>{

}
