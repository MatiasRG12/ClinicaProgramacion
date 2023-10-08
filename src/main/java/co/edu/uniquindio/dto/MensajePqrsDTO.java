package co.edu.uniquindio.dto;

import java.time.LocalDateTime;

public record MensajePqrsDTO(
        int codigoMensaje,
        String texto,
        LocalDateTime fecha
) {

}
