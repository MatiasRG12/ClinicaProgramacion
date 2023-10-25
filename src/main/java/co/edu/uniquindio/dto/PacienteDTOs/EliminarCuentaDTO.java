package co.edu.uniquindio.dto.PacienteDTOs;

import jakarta.validation.constraints.NotBlank;

public record EliminarCuentaDTO(

        @NotBlank
        int codigo,

        @NotBlank
        String contrasenia
) {
}
