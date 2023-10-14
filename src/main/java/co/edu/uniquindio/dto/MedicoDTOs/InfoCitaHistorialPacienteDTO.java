package co.edu.uniquindio.dto.MedicoDTOs;

import co.edu.uniquindio.modelo.enumeraciones.EstadoCita;

import java.time.LocalDateTime;

public record InfoCitaHistorialPacienteDTO(

        int codigoCita,
        EstadoCita estadoCita,
        LocalDateTime fechaCita,
        String nombreMedico

) {
}
