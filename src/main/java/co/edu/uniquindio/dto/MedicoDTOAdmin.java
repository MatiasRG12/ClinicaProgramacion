package co.edu.uniquindio.dto;

import co.edu.uniquindio.modelo.enumeraciones.Especialidad;

public record MedicoDTOAdmin(
        String cedula,
        String nombre,
        String urlFoto,
        Especialidad especialidad)
    {
}
