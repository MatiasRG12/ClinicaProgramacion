package co.edu.uniquindio.dto.AdminDTOs;

import co.edu.uniquindio.modelo.enumeraciones.EstadoCita;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record InfoCitaDTOAdmin(

    @NotBlank
    int codigoCita,

    EstadoCita estado,

    LocalDateTime fecha,

    @NotBlank
    @Length(max = 40)
    String nombrePaciente
){
}
