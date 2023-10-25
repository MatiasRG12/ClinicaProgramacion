package co.edu.uniquindio.dto.PacienteDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FiltroCitaEspDTO(

        @NotBlank
        int codigoPaciente,

        @NotNull
        int codigoEspecialidad
) {
}
