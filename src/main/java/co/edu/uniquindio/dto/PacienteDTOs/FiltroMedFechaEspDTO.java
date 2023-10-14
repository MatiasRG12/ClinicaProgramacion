package co.edu.uniquindio.dto.PacienteDTOs;

import java.time.LocalDateTime;

public record FiltroMedFechaEspDTO(
        int codigoPaciente,
        String nombreMedico,
        LocalDateTime fecha,
        int especialidad
) {
}
