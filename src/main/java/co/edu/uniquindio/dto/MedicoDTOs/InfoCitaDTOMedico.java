package co.edu.uniquindio.dto.MedicoDTOs;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record InfoCitaDTOMedico(
        int codigo,
        LocalDateTime fecha,
        LocalTime hora,
        String nombrePaciente
) {
}
