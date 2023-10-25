package co.edu.uniquindio.dto.CompartidosDTOs;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record MensajePqrsDTO(

        @NotBlank
        int codigoMensaje,
        String texto,
        LocalDateTime fecha
) {

}
