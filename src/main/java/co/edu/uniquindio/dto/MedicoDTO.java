package co.edu.uniquindio.dto;

import co.edu.uniquindio.modelo.enumeraciones.Especialidad;
import co.edu.uniquindio.modelo.enumeraciones.EstadoMedico;
import co.edu.uniquindio.modelo.enumeraciones.Jornada;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Setter
@Getter
public record MedicoDTO(

        String nombre,
        String cedula,
        String ciudad,
        Especialidad especialidad,
        String telefono,
        String correo,
        String password,
        Jornada jornada,
        EstadoMedico estado

) {

}
