package co.edu.uniquindio.dto.MedicoDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record InfoCitaDTOMedico(

        @NotBlank
        int codigo,

        @NotNull
        LocalDateTime fecha,

        @NotNull
        LocalTime hora,

        @NotBlank
        @Length(max = 40)
        String nombrePaciente
) {
}
