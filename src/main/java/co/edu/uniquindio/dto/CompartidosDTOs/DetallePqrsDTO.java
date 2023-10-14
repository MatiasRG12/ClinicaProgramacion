package co.edu.uniquindio.dto.CompartidosDTOs;

import co.edu.uniquindio.modelo.enumeraciones.EstadoPqrs;
import co.edu.uniquindio.modelo.enumeraciones.TipoPqrs;

import java.time.LocalDateTime;
import java.util.List;

public record DetallePqrsDTO(
        int codigo,
        TipoPqrs tipo,
        EstadoPqrs estado,
        LocalDateTime fecha,
        String motivo,
        List<MensajePqrsDTO> mensajes
) {
}
