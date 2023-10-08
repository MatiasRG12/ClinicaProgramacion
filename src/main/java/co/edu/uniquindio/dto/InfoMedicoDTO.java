package co.edu.uniquindio.dto;

import co.edu.uniquindio.modelo.enumeraciones.Especialidad;
import co.edu.uniquindio.modelo.enumeraciones.EstadoMedico;
import co.edu.uniquindio.modelo.enumeraciones.Jornada;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public record InfoMedicoDTO(
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
