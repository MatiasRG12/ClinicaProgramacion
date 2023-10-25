package co.edu.uniquindio.dto.PacienteDTOs;

import co.edu.uniquindio.modelo.enumeraciones.Eps;
import co.edu.uniquindio.modelo.enumeraciones.TipoSangre;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record RegistroPacienteDTO(

        @NotBlank
        @Length(max = 40)
        String nombre,

        @NotBlank
        @Length(max = 15)
        String cedula,

        String ciudad,

        @Length(max = 15)
        String telefono,

        @NotNull
        LocalDateTime fechaNacimiento,

        String fotoUrl,

        @NotNull
        Eps eps,

        @NotNull
        TipoSangre tipoSangre,

        String alergias,

        @NotBlank
        @Length(max = 50)
        @Email
        String correo,

        @NotBlank
        String contrasenia
) {
}
