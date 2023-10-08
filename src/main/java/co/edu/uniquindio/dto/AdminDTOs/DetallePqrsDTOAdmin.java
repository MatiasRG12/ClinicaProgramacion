package co.edu.uniquindio.dto.AdminDTOs;

import co.edu.uniquindio.dto.MensajePqrsDTO;
import co.edu.uniquindio.modelo.entidades.MensajePqrs;
import co.edu.uniquindio.modelo.enumeraciones.Especialidad;
import co.edu.uniquindio.modelo.enumeraciones.EstadoPqrs;

import java.time.LocalDateTime;
import java.util.List;

public record DetallePqrsDTOAdmin(
        int codigo,
        String tipo,
        EstadoPqrs estado,
        LocalDateTime fecha,
        String motivo,
        List<MensajePqrsDTO> mensajes
) {
}
