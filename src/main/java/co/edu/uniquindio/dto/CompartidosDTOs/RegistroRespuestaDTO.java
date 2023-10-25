package co.edu.uniquindio.dto.CompartidosDTOs;

import jakarta.validation.constraints.NotBlank;

public record RegistroRespuestaDTO(

        @NotBlank
        int codigoPqrs,
        int codigoMensaje,
        String mensaje
) {
}
