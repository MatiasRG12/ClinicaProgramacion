package co.edu.uniquindio.dto.AdminDTOs;

import co.edu.uniquindio.modelo.enumeraciones.Especialidad;

public record InfoMedicoDTO(
        String cedula,
        String nombre,
        Especialidad especialidad
) {
}
