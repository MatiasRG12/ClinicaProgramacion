package co.edu.uniquindio.dto.PacienteDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record FiltroCitaFechaDTO(

        @NotBlank
        int codigoPaciente,

        @NotNull
        LocalDateTime fecha
) {
}
