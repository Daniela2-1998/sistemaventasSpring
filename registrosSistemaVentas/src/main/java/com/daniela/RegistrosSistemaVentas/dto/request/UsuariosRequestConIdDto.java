package com.daniela.RegistrosSistemaVentas.dto.request;

import com.daniela.RegistrosSistemaVentas.model.Usuarios;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuariosRequestConIdDto {

    @NotNull(message = "El campo ID del usuario no puede ser nulo.")
    private Long id;

    @NotNull(message = "El campo nombre de usuario no puede ser nulo.")
    @NotEmpty(message = "El campo nombre de usuario no puede estar vacío.")
    @Size(min = 4, max = 12)
    @Column(name = "usuario")
    private String nombreUsuario;

    @Size(min = 6, max = 15, message = "La contraseña debe tener entre 6 y 15 caracteres.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = "La contraseña debe contener al menos una mayúscula, " +
                    "una minúscula, un número y un carácter especial")
    private String contraseña;

    @NotBlank(message = "No puede quedar vacío el mail.")
    @Email
    private String mail;

    @Enumerated(EnumType.STRING)
    private Usuarios.Rol rol;

    @Enumerated(EnumType.STRING)
    private Usuarios.Estado estado;
}
