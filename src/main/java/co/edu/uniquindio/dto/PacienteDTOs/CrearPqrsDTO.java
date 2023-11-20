package co.edu.uniquindio.dto.PacienteDTOs;

import co.edu.uniquindio.modelo.enumeraciones.TipoPqrs;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record CrearPqrsDTO(

        @NotNull
        TipoPqrs tipoSolicitud,

        @NotBlank
        @Length(max = 500)
        String motivo,

        int codigoCita
) {
}
