package co.edu.uniquindio.dto;

import co.edu.uniquindio.modelo.entidades.Ciudad;

import java.util.List;

public record MedicoDTO(
        String nombre,
        String cedula,
        Ciudad ciudad, //revisar esta parte
        int codigoEspecialidad,
        String telefono,
        String correo,
        String password,
        List< HorarioDTO > horarios

) {
}
