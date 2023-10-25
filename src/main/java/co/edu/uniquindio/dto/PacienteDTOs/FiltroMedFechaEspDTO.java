package co.edu.uniquindio.dto.PacienteDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record FiltroMedFechaEspDTO(

        @NotBlank
        int codigoPaciente,

        @NotBlank
        @Length(max = 40)
        String nombreMedico,

        @NotNull
        LocalDateTime fecha,

        @NotBlank
        int especialidad
) {
}
