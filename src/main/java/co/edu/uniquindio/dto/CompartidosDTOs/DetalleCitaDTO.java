package co.edu.uniquindio.dto.CompartidosDTOs;

import co.edu.uniquindio.modelo.enumeraciones.TipoSangre;
import java.time.LocalDateTime;

public record DetalleCitaDTO(
        LocalDateTime fecha,
        String nombreMedico,
        String nombrePaciente,
        TipoSangre tipoSangrePaciente,
        String motivo,
        String sintomas,
        String diagnostico,
        String tratamiento,
        String notas
) {
}
