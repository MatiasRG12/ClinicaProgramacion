package co.edu.uniquindio.dto.CompartidosDTOs;

import jakarta.validation.constraints.NotBlank;

public record CambiarContraseniaDTO(

        @NotBlank
        int codigo,

        @NotBlank
        String contraseniaActual,

        @NotBlank
        String contraseniaNueva
) {
}
