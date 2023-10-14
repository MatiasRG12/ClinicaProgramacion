package co.edu.uniquindio.dto.PacienteDTOs;

import java.time.LocalDate;
import java.time.LocalTime;

public record ItemFechaMedicoDTO(

        LocalDate fecha,
        LocalTime hora,
        String nombreMedico
) {
}
