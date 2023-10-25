package co.edu.uniquindio.dto.extrasDTOs;

public record MensajeDTO<T>(
        boolean error,
        String mensaje,
        T respuesta
) {
}
