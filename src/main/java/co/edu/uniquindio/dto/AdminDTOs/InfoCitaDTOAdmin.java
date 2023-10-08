package co.edu.uniquindio.dto.AdminDTOs;

import co.edu.uniquindio.modelo.enumeraciones.EstadoCita;
import java.time.LocalDateTime;

public record InfoCitaDTOAdmin(
    int codigoCita,
    EstadoCita estado,
    LocalDateTime fecha,
    String nombrePaciente
    ){
}
