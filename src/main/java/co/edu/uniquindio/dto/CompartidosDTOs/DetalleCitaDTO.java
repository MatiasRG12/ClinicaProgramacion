package co.edu.uniquindio.dto.CompartidosDTOs;

import co.edu.uniquindio.modelo.enumeraciones.TipoSangre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record DetalleCitaDTO(

        @NotBlank
        LocalDateTime fecha,

        @NotBlank
        @Length(max = 40)
        String nombreMedico,

        @NotBlank
        @Length(max = 40)
        String nombrePaciente,

        @NotNull
        TipoSangre tipoSangrePaciente,

        @NotBlank
        @Length(max = 100)
        String motivo,

        String sintomas,

        String diagnostico,

        String tratamiento,

        String notas
) {
}
