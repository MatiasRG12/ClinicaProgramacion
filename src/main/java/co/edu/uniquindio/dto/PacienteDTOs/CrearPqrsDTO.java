package co.edu.uniquindio.dto.PacienteDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record CrearPqrsDTO(

        @NotNull
        int tipoSolicitud,

        @NotBlank
        @Length(max = 500)
        String motivo,

        @NotBlank
        int codigoCita
) {
}
