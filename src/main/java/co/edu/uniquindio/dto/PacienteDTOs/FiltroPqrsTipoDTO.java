package co.edu.uniquindio.dto.PacienteDTOs;

import jakarta.validation.constraints.NotBlank;

public record FiltroPqrsTipoDTO(

        @NotBlank
        int codigoPaciente,

        @NotBlank
        int tipoPqrs
) {
}
