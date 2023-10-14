package co.edu.uniquindio.dto.PacienteDTOs;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record AgendarCitaDTO(
        int codigoMedico,
        int codigoPaciente,
        String motivoCita,
        LocalDateTime fechaCita,
        LocalTime horaCita

) {
}
