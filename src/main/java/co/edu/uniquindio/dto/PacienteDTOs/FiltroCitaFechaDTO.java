package co.edu.uniquindio.dto.PacienteDTOs;

import java.time.LocalDateTime;

public record FiltroCitaFechaDTO(
        int codigoPaciente, LocalDateTime fecha
) {
}
