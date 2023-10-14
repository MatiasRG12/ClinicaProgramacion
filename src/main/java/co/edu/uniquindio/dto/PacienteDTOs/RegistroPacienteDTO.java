package co.edu.uniquindio.dto.PacienteDTOs;

import co.edu.uniquindio.modelo.enumeraciones.Eps;
import co.edu.uniquindio.modelo.enumeraciones.TipoSangre;

import java.time.LocalDateTime;

public record RegistroPacienteDTO(

        String nombre,
        String cedula,
        String ciudad,
        String telefono,
        LocalDateTime fechaNacimiento,
        String fotoUrl,
        Eps eps,
        TipoSangre tipoSangre,
        String alergias,
        String correo,
        String contrasenia
) {
}
