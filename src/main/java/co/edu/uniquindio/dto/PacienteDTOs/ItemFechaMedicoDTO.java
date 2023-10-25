package co.edu.uniquindio.dto.PacienteDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalTime;

public record ItemFechaMedicoDTO(

        @NotNull
        LocalDate fecha,

        @NotNull
        LocalTime hora,

        @NotBlank
        @Length(max = 40)
        String nombreMedico
) {
}
