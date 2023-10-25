package co.edu.uniquindio.dto.MedicoDTOs;

import co.edu.uniquindio.modelo.enumeraciones.EstadoCita;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record CitaHistorialMedicoDTO(

        @NotBlank
        int codigoCita,

        @NotNull
        EstadoCita estadoCita,

        @NotNull
        LocalDateTime fechaCita,

        @NotBlank
        @Length(max = 40)
        String nombrePaciente

) {
}
