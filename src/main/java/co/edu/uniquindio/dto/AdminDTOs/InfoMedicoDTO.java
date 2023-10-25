package co.edu.uniquindio.dto.AdminDTOs;

import co.edu.uniquindio.modelo.enumeraciones.Especialidad;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record InfoMedicoDTO(

        @NotBlank
        @Length(max = 15)
        String cedula,

        @NotBlank
        @Length(max = 40)
        String nombre,

        Especialidad especialidad
) {
}
