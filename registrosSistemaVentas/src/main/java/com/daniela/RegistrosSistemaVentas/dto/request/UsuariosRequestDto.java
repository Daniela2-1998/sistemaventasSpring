package com.daniela.RegistrosSistemaVentas.dto.request;

import com.daniela.RegistrosSistemaVentas.model.Usuarios;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuariosRequestDto {

    @NotNull(message = "El campo nombre de usuario no puede ser nulo.")
    @NotEmpty(message = "El campo nombre de usuario no puede estar vacío.")
    @Size(min = 4, max = 12)
    @Column(name = "usuario")
    private String nombreUsuario;

    private String contraseña;

    @NotBlank(message = "No puede quedar vacío el mail.")
    @Email
    private String mail;

    @NotNull(message = "El rol de usuario no puede ser nulo.")
    @NotEmpty(message = "El rol de usuario no puede estar vacío.")
    private Usuarios.Rol rol;

    @NotNull(message = "El estado del usuario no puede ser nulo.")
    @NotEmpty(message = "El estado del usuario no puede estar vacío.")
    private String estado;
}
