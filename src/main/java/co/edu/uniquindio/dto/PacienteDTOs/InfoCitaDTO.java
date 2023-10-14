package co.edu.uniquindio.dto.PacienteDTOs;

import co.edu.uniquindio.modelo.enumeraciones.Especialidad;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record InfoCitaDTO(

        int codigo,
        Especialidad especialidad,
        LocalDateTime fechaCita, //NO ES FECHA DE CREACION
        LocalTime horaCita,
        String nombreMedico

) {
}
