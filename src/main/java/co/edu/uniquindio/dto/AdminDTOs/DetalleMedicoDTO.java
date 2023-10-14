package co.edu.uniquindio.dto.AdminDTOs;

import co.edu.uniquindio.modelo.enumeraciones.Especialidad;
import co.edu.uniquindio.modelo.enumeraciones.EstadoMedico;
import co.edu.uniquindio.modelo.enumeraciones.Jornada;

public record DetalleMedicoDTO(
        String nombre,
        String cedula,
        String ciudad,
        Especialidad especialidad,
        String telefono,
        String correo,
        Jornada jornada,
        EstadoMedico estado
) {
}