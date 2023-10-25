package co.edu.uniquindio.dto.PacienteDTOs;

import co.edu.uniquindio.modelo.enumeraciones.Especialidad;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ItemMedicoDTO(

        @NotBlank
        int codigo,

        @NotNull
        Especialidad especialidad
) {
}
