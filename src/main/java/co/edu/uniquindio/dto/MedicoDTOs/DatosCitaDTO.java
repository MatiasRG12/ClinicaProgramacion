package co.edu.uniquindio.dto.MedicoDTOs;


import co.edu.uniquindio.modelo.enumeraciones.TipoSangre;

import java.time.LocalDateTime;

public record DatosCitaDTO(
        LocalDateTime fechaCita,
        String nombreMedico,
        String nombrePaciente,
        TipoSangre tipoSangrePaciente,
        String moticoCita
) {
}
