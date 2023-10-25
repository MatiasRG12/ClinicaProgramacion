package co.edu.uniquindio.dto.AdminDTOs;

import co.edu.uniquindio.modelo.enumeraciones.Especialidad;
import co.edu.uniquindio.modelo.enumeraciones.EstadoMedico;
import co.edu.uniquindio.modelo.enumeraciones.Jornada;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record DetalleMedicoDTO(

        @NotBlank
        @Length(max = 40)
        String nombre,

        @NotBlank
        @Length(max = 15)
        String cedula,

        String ciudad,

        Especialidad especialidad,

        @Length(max = 15)
        String telefono,

        @NotBlank
        @Length(max = 50)
        String email,

        Jornada jornada,

        EstadoMedico estado
) {
}
