package co.edu.uniquindio.dto.PacienteDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record AgendarCitaDTO(

        @NotBlank
        int codigoMedico,

        @NotBlank
        int codigoPaciente,

        @NotBlank
        @Length(max = 100)
        String motivoCita,

        @NotNull
        LocalDateTime fechaCita,

        @NotNull
        LocalTime horaCita

) {
}
