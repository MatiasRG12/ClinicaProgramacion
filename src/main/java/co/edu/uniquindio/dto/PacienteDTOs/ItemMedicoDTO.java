package co.edu.uniquindio.dto.PacienteDTOs;

import co.edu.uniquindio.modelo.enumeraciones.Especialidad;

public record ItemMedicoDTO(

        int codigo,
        Especialidad especialidad
) {
}
